package com.github.chosamuel.tsaotools.geometry.circle

import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
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