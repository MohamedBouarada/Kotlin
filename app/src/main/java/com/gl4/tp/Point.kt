package com.gl4.tp
import kotlin.math.abs

data class Point(var x:Int , var y:Int) {

    fun distance(q:Point) : Int {
        return (abs(q.x - this.x) + abs(q.y - this.y))
    }

    override fun toString(): String {
        return "($x,$y)"
    }
}