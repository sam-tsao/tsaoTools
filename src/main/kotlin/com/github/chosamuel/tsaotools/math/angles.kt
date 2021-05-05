package com.github.chosamuel.tsaotools.math

import kotlin.math.PI

val Double.asDegrees : Double
    get() = this * 180.0 / PI

val Double.asRadians : Double
    get() = this / 360.0 * 2 * PI