package com.github.chosamuel.tsaotools.geometry.line

import org.openrndr.math.Vector2
import org.openrndr.shape.LineSegment

fun yIntercept(pt: Vector2, m: Double): Double {
    return m * (0.0 - pt.x) + pt.y
}

//for unknown slope
fun yIntercept(a: Vector2, b:Vector2): Double{
    val m = slope(a,b)
    return m * (0.0 - a.x) + a.y
}

fun yIntercept(l: List<Vector2>): Double{
    val m = slope(l[0],l[1])
    return m * (0.0 - l[0].x) + l[0].y
}

fun yIntercept(l: LineSegment): Double{
    val m = slope(l.start,l.end)
    return m * (0.0 - l.start.x) + l.start.y
}

val LineSegment.yIntercept: Double
    get() = this.slope * (0.0 - this.start.x) + this.start.y