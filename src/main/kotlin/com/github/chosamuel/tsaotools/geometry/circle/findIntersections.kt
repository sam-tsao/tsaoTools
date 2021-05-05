package com.github.chosamuel.tsaotools.geometry.circle

import com.github.chosamuel.tsaotools.geometry.line.getStandardLine
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import org.openrndr.shape.LineSegment
import kotlin.math.sqrt

fun Circle.findIntersections(other: Circle): List<Vector2>{
    //distance
    val d = this.center.minus(other.center).length
    //calculate a, distance from c1 to intersecting line
    val a = (this.radius*this.radius - other.radius*other.radius + d*d) / (2*d)
    //calculate h, distance from a to intersecting point
    val h = sqrt(this.radius*this.radius - a*a)
    val p2 = other.center.minus(this.center)
        .normalized
        .times(a)
        .plus(this.center)
    val p3 = other.center.minus(this.center)
        .rotate(90.0)
        .normalized
        .times(h)
        .plus(p2)
    val p4 = other.center.minus(this.center)
        .rotate(-90.0)
        .normalized
        .times(h)
        .plus(p2)
    return listOf(p3,p4)
}

fun Circle.findIntersections(line: LineSegment): List<Vector2>{
    val a = this.center.x
    val b = this.center.y
    val r = this.radius
    val x = this.center.x + r
    val y = this.center.y
    val r2 = r*r
    val (m, d) = getStandardLine(line)
    val m2 = m*m
    val delta = r2 *( 1.0 + m2) - ((b - m*a - d)*(b - m*a - d))
    val x1 = (a + b*m - d*m + sqrt(delta)) / (1.0 + m2)
    val x2 = (a + b*m - d*m - sqrt(delta)) / (1.0 + m2)
    val y1 = (d + a*m + b*m2 + m* sqrt(delta)) / (1.0 + m2)
    val y2 = (d + a*m + b*m2 - m* sqrt(delta)) / (1.0 + m2)
    return listOf(Vector2(x1,y1), Vector2(x2,y2))
}