pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement{
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Movie Compose"
include(":app")
include(":core-ui")
include(":feature-dashboard-impl")
include(":feature-dashboard-api")
include(":feature-favoriteList-impl")
include(":feature-favoriteList-api")
include(":feature-movie-api")
include(":feature-movie-impl")
include(":core-model")
include(":core-network")
include(":data-movie")
include(":domain-movie")
include(":base-data")
include(":base-domain")
include(":core-network-model")
