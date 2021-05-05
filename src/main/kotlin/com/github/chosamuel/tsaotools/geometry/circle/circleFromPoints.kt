package com.github.chosamuel.tsaotools.geometry.circle

import com.github.chosamuel.tsaotools.geometry.line.findIntersection
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import org.openrndr.shape.LineSegment

//Geometric solution to finding a circle that touches three given points
fun circleFromPoints(pts: List<Vector2>): Circle {
    val bisectors = generateBisectors(pts)
    val bisectingLines = generateBisectorLines(pts, bisectors)
    val intersection = bisectingLines[0].findIntersection(bisectingLines[1])
    return Circle(intersection, (intersection - pts[0]).length)
}

fun generateBisectors(pts: List<Vector2>): List<Vector2> {
    val bisectors = mutableListOf<Vector2>()
    for(i in 0 until pts.size){
        if(i < pts.size - 1) {
            val bisector = pts[i] + ((pts[i + 1] - pts[i]) * 0.5)
            bisectors.add(bisector)
        }
    }
    return bisectors
}
fun generateBisectorLines(
    lines: List<Vector2>,
    bisectors: List<Vector2>
):List<LineSegment>{
    assert(lines.size == 3)
    val bisectorLines = mutableListOf<LineSegment>()
    lines.forEachIndexed { i, line ->
        if(i < lines.size-1) {
            val dir = lines[i + 1] - lines[i]
            val bitangent = dir.rotate(90.0).normalized
            bisectorLines.add(
                LineSegment(
                    bisectors[i] + bitangent * 500.0,
                    bisectors[i] - bitangent * 500.0
                )
            )
        }
    }
    return bisectorLines
}