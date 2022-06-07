package com.onurkaragunlu.feature.dashboard.api.navigation

sealed class DashboardNavigation(val route: String) {
    object DashBoard : DashboardNavigation("dashboard")
}