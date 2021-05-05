package com.github.chosamuel.tsaotools.geometry.circle

import org.openrndr.shape.Circle

fun Circle.contains(other: Circle): Boolean {
    val d= this.center.distanceTo(other.center)
    return (d+other.radius) < this.radius
}