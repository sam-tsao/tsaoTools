package com.github.chosamuel.tsaotools.geometry.circle

import org.openrndr.shape.Circle

//calculating distance between two circles based on their center
fun Circle.distanceTo(other: Circle): Double = this.center.distanceTo(other.center)