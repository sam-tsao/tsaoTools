package com.github.chosamuel.tsaotools.geometry.circle

import org.openrndr.shape.Circle

/*
Resolves the collision of two circles and return
their new positions as list of circles
eg:
c1 = c1.moved(vel1)
c2 = c2.moved(vel2)
if(c1.intersects(c2)) {
    val (n1, n2) = c1.collide(c2)
    c1 = n1
    c2 = n2
}
 */

data class Circle2(val c1: Circle, val c2: Circle)

fun Circle.collide(other: Circle): Circle2 {
    val d = this.distanceTo(other)
    val overlap = (d - radius - other.radius) * 0.5
    val c1 = Circle(
        center - (center.minus(other.center).times(overlap).div(d)),
        radius
    )
    val c2 = Circle(
        other.center + (center.minus(other.center).times(overlap).div(d)),
        other.radius
    )
    return Circle2(c1,c2)
}
