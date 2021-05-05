package com.github.chosamuel.tsaotools.geometry.line

import org.openrndr.math.Vector2
import org.openrndr.shape.LineSegment

data class StandardLine(val m: Double, val c: Double)

fun getStandardLine(a: Vector2, b: Vector2): StandardLine {
    val m = slope(a,b);
    val c = yIntercept(a,b)
    return StandardLine(m,c)
}

fun getStandardLine(l: List<Vector2>): StandardLine {
    val m = slope(l);
    val c = yIntercept(l)
    return StandardLine(m,c)
}

fun getStandardLine(l: LineSegment): StandardLine {
    val m = slope(l);
    val c = yIntercept(l)
    return StandardLine(m,c)
}

