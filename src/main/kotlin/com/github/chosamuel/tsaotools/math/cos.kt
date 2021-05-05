package com.github.chosamuel.tsaotools.math

import org.openrndr.math.Vector3
import kotlin.math.cos

//GLM style
fun cos(vec3: Vector3): Vector3 {
    return Vector3(
        cos(vec3.x),
        cos(vec3.y),
        cos(vec3.z)
    )
}

