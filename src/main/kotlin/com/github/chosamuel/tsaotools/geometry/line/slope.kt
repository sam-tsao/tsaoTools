package com.github.chosamuel.tsaotools.geometry.line

import org.openrndr.math.Vector2
import org.openrndr.shape.LineSegment

fun slope(v: Vector2): Double = v.x / v.y
fun slope(a: Vector2, b: Vector2): Double = (b.y - a.y) / (b.x - a.x)
fun slope(l: List<Vector2>): Double = (l[1].y - l[0].y) / (l[1].x - l[0].x)
fun slope(l: LineSegment): Double = (l.end.y - l.start.y) / (l.end.x - l.start.x)

val LineSegment.slope : Double
    get() = ((this.end.y - this.start.y) / (this.end.x - this.start.x))

