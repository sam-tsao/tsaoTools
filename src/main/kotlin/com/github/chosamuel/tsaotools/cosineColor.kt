package com.github.chosamuel.tsaotools

import org.openrndr.color.ColorRGBa
import org.openrndr.math.Vector3
import kotlin.math.PI
import kotlin.math.cos

fun cosineColor(
    t: Double,
    a: Vector3 = Vector3(0.5),
    b: Vector3 = Vector3(0.5),
    c: Vector3 = Vector3(1.0,0.7,0.4),
    d: Vector3 = Vector3(0.0,0.15,0.2),
):ColorRGBa {
    val color = ColorRGBa(
        (a.x + b.x * cos(2*PI * (c.x*t+d.x))),
        (a.y + b.y * cos(2*PI * (c.y*t+d.y))),
        (a.z + b.z * cos(2*PI * (c.z*t+d.z)))
    );
    return color
}