package com.github.chosamuel.tsaotools.geometry.circle

import org.openrndr.shape.Circle

fun Circle.intersects(other: Circle): Boolean {
    val d = this.center.distanceTo(other.center)
    return d < (this.radius + other.radius)
}