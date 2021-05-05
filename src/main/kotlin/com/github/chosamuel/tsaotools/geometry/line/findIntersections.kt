package com.github.chosamuel.tsaotools.geometry.line

import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import org.openrndr.shape.LineSegment
import kotlin.math.sqrt

fun LineSegment.findIntersections(c: Circle): List<Vector2>{
    val a = c.center.x
    val b = c.center.y
    val r = c.radius
    val x = c.center.x + r
    val y = c.center.y
    val r2 = r*r
    val (m, d) = getStandardLine(this)
    val m2 = m*m
    val delta = r2 *( 1.0 + m2) - ((b - m*a - d)*(b - m*a - d))
    val x1 = (a + b*m - d*m + sqrt(delta)) / (1.0 + m2)
    val x2 = (a + b*m - d*m - sqrt(delta)) / (1.0 + m2)
    val y1 = (d + a*m + b*m2 + m* sqrt(delta)) / (1.0 + m2)
    val y2 = (d + a*m + b*m2 - m* sqrt(delta)) / (1.0 + m2)
    return listOf(Vector2(x1,y1), Vector2(x2,y2))
}
