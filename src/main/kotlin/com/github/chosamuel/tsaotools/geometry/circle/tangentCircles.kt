package com.github.chosamuel.tsaotools.geometry.circle

import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import kotlin.math.cos
import kotlin.math.sin

//given a circle, generate a new circle that is tangent to it
fun tangentCircle(base: Circle, radius: Double, theta: Double = 0.0): Circle {
    val pos = Vector2(
        cos(theta) * (base.radius + radius) + base.center.x,
        sin(theta) * (base.radius + radius) + base.center.y,
    )
    return Circle(pos,radius)
}

//given two tangent circles, generate a new circle that is tangent to both
//there are two solutions
fun doubleTangentCircle(r: Double, c1: Circle, c2: Circle): List<Circle>{
    val centers = Circle(c1.center,c1.radius+r)
        .findIntersections(Circle(c2.center,c2.radius+r))
    val circles = mutableListOf<Circle>()
    centers.forEach { v->
        circles.add(Circle(v,r))
    }
    return circles
}