package kz.meken.fragmentlifecycleexploring.di

import kz.meken.fragmentlifecycleexploring.some.SomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SomeViewModel() }
}