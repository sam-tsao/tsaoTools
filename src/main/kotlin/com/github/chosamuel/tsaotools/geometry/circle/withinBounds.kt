package com.github.chosamuel.tsaotools.geometry.circle

import org.openrndr.shape.Circle

fun Circle.withinBounds(
    leftBounds: Double = 0.0,
    topBounds: Double = 0.0,
    rightBounds: Double,
    bottomBounds: Double
): Boolean{
    return this.center.x < rightBounds && this.center.x > leftBounds &&
            this.center.y < bottomBounds && this.center.y > topBounds
}