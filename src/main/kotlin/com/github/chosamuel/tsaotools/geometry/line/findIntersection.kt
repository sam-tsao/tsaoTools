package com.github.chosamuel.tsaotools.geometry.line

import org.openrndr.math.Vector2
import org.openrndr.shape.LineSegment


fun LineSegment.findIntersection(line: LineSegment): Vector2{
    val a1 = this.end.y - this.start.y
    val b1 = this.start.x - this.end.x
    val c1 = a1 * this.start.x + b1 * this.start.y

    val a2 = line.end.y - line.start.y
    val b2 = line.start.x - line.end.x
    val c2 = a2 * line.start.x + b2 * line.start.y

    val d = a1 * b2 - a2 * b1
    return Vector2(
        (b2*c1-b1*c2) / d,
        (a1 * c2 - a2 * c1) / d
    )
}
