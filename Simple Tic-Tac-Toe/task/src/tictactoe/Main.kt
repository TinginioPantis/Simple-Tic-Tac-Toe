package tictactoe

import kotlin.math.absoluteValue


fun main() {
//    // Reading
//    println("Enter cells:")
//    val input = readLine()!!
//
//    // Parsing
//    val game = parse(input)
//
//    // Calculating
//    val gameResult = analyze(game)
//
//    // Rendering
//    val gameStr = renderGame(game)
//    //val resultStr = render(gameResult)
//
//    // Outputting
//    println(gameStr)
//    //println(resultStr)
//
//    val correctCoordinates = readCoordinatesUntilValid(game)
//
//    game[correctCoordinates.first][correctCoordinates.second] = XO.X
//    println(renderGame(game))

    // sukurti tuscia 3x3 grida
    val game = createGame()
    // ispausdinti tuscia 3x3 grida
    println(renderGame(game))
    // sukurti kintamaji, kuris skaiciuotu kieno eile, X pradeda
    var activePlayer = XO.X

    // kartosi tol kol kazkas laimi arba draw {
    while (
        when (analyze(game)) {
            GameResult.GameNotFinished -> true
            GameResult.Draw -> false
            GameResult.XWins -> false
            GameResult.OWins -> false
            GameResult.Impossible -> throw Exception("This should never happen...")
        }
    ) {
        // Paprasyti ivesti koordinates (kol jos bus tinkamos)
        val correctCoordinates = readCoordinatesUntilValid(game)
        // Pazymeti koordinates ant grido
        game[correctCoordinates.first][correctCoordinates.second] = activePlayer
        // Ispausdinti atnaujinta grida
        println(renderGame(game))
        // Kintamasis suskaiciuoja, kad X jau paejo, ir toliau eina O. Patoglini kieno ejimas
        activePlayer = toggle(activePlayer)
    }
    // game |> analyze |> render |> println
    println(render(analyze(game)))
}

fun readCoordinates(): Pair<Int, Int>? {
    val coordinates = readLine()!!.split(" ")
    if (coordinates.size != 2) return null
    val rowCoordinate = coordinates[0].toIntOrNull()
    val columnCoordinate = coordinates[1].toIntOrNull()
    if (rowCoordinate == null || columnCoordinate == null) return null
    return Pair(rowCoordinate - 1, columnCoordinate - 1)
}

fun analyzeCoordinates(game: Game, rowIdx: Int, colIdx: Int): String? {
    val validRange = 1..3
    if (!validRange.contains(rowIdx + 1) || !validRange.contains(colIdx + 1)) {
        return "Coordinates should be from 1 to 3!"
    }
    else if (game[rowIdx][colIdx] != null) {
        return "This cell is occupied! Choose another one!"
    }
    else return null
}

fun readCoordinatesUntilValid(game: Game): Pair<Int, Int> {
    while (true) {
        println("Enter the coordinates:")
        val coordinates = readCoordinates()
        if (coordinates == null) {
            println("You should enter numbers!")
        }
        else {
            val maybeError = analyzeCoordinates(game, coordinates.first, coordinates.second)
            if (maybeError == null) {
                return coordinates
            } else {
                println(maybeError)
            }
        }
    }
}

//region Data types (structured data)

// product types
//data class Seat(val taken: Boolean, val name: String)

// sum types
enum class XO { X, O }

typealias Row = MutableList<XO?>
typealias Game = MutableList<Row>

enum class GameResult { GameNotFinished, Draw, XWins, OWins, Impossible }
//endregion

//region Parsing functions
fun createGame(): Game =
        MutableList(3) { MutableList(3) { null } }

fun parse(input: String): Game =
        input.chunked(3).map { parseChunk(it) }.toMutableList()

fun parseChunk(chunk: String): Row =
        chunk.indices.map { idx -> parseChar(chunk[idx]) }.toMutableList()

fun parseChar(c: Char): XO? =
        when (c) {
            'X' -> XO.X
            'O' -> XO.O
            '_' -> null
            else -> throw Exception("Unknown input '$c'")
        }
//endregion

//region Calculating functions

fun toggle(xo: XO): XO = if (xo == XO.O) XO.X else XO.O

fun analyze(game: Game): GameResult {
    val xStrokes = countFullStrokes(game, XO.X)
    val oStrokes = countFullStrokes(game, XO.O)
    val xCount = countXO(game, XO.X)
    val oCount = countXO(game, XO.O)
    val xoDiff = (xCount - oCount).absoluteValue

    if (
        xStrokes >= 2 || oStrokes >= 2 || xStrokes == 1 && oStrokes == 1
        || xoDiff >= 2
    ) {
        return GameResult.Impossible
    }
    else if (oStrokes == 1) return GameResult.OWins
    else if (xStrokes == 1) return GameResult.XWins
    else if (!hasEmptyCells(game)) return GameResult.Draw
    else return GameResult.GameNotFinished
}

fun hasEmptyCells(game: Game): Boolean {
    return game.any { row -> row.contains(null) }
}

fun countFullStrokes(game: Game, checkFor: XO): Int {
    val inRows = game.indices.count { checkIfFullRow(game, it, checkFor) }
    val inCols = game.indices.count { checkIfFullColumn(game, it, checkFor) }
    val diagonal1 = if (checkIfFullDiagonal(game, checkFor)) 1 else 0
    val diagonal2 = if (checkIfFullCounterDiagonal(game, checkFor)) 1 else 0
    return inRows + inCols + diagonal1 + diagonal2
}

/** Returns true if row at `rowIdx` has only the specified X or O. */
fun checkIfFullRow(game: Game, rowIdx: Int, checkFor: XO): Boolean {
    val row = game[rowIdx]
    return checkIfFull(row, checkFor)
}

fun checkIfFullColumn(game: Game, colIdx: Int, checkFor: XO): Boolean {
    val col = game.map { row -> row[colIdx] }
    return checkIfFull(col, checkFor)
}

fun checkIfFull(list: List<XO?>, checkFor: XO): Boolean {
    return list.all { maybeXO -> maybeXO == checkFor }
}

/**
 * Checks this diagonal:
 * X
 *  X
 *   X
 */
fun checkIfFullDiagonal(game: Game, checkFor: XO): Boolean {
    val diagonal = game.indices.map { idx -> game[idx][idx] }
    return checkIfFull(diagonal, checkFor)
//    game[0][0] == checkFor && game[1][1] == checkFor && game[2][2] == checkFor
}

/**
 * Checks this diagonal:
 *   X
 *  X
 * X
 */
fun checkIfFullCounterDiagonal(game: Game, checkFor: XO): Boolean {
    val maxIdx = game.indices.last
    val otherDiagonal = game.indices.map { idx -> game[idx][maxIdx - idx] }
    return checkIfFull(otherDiagonal, checkFor)
//    game[0][2] == checkFor && game[1][1] == checkFor && game[2][0] == checkFor
//    game[0][maxIdx - 0] == checkFor && game[1][maxIdx - 1] == checkFor
//            && game[2][maxIdx - 2] == checkFor
}

fun countXO(game: Game, checkFor: XO): Int {
    return game.sumOf { row -> countXOinRow(row, checkFor) }
}

fun countXOinRow(row: Row, checkFor: XO): Int {
    return row.count { maybeXO -> maybeXO == checkFor }
}
//endregion

//region Rendering functions
fun renderGame(game: Game): String {
    var str = "---------\n"
    for (row in game) {
        val line = row.joinToString(" ") {
            when (it) {
                XO.X -> "X"
                XO.O -> "O"
                null -> "_"
            }
        }
        str += "| $line |\n"
    }
    str += "---------"

    return str
}
fun render(result: GameResult): String = when (result) {
    GameResult.GameNotFinished -> "Game not finished"
    GameResult.Draw -> "Draw"
    GameResult.XWins -> "X wins"
    GameResult.OWins -> "O wins"
    GameResult.Impossible -> "Impossible"
}
//endregion