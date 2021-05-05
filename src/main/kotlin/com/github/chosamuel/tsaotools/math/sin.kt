package com.github.chosamuel.tsaotools.math

import org.openrndr.math.Vector3
import kotlin.math.sin

fun sin(vec3: Vector3): Vector3 {
    return Vector3(
        kotlin.math.sin(vec3.x),
        kotlin.math.sin(vec3.y),
        kotlin.math.sin(vec3.z)
    )
}
