package com.sollwar.testcalc

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}
interface Navigator {
    fun singInSuccess()
}