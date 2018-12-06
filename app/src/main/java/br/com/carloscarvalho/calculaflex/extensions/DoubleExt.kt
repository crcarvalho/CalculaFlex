package br.com.carloscarvalho.calculaflex.extensions

fun Double.format(digits: Int) = String.format("%.${digits}f", this)