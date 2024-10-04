package dev.prodeva.weatherapplication.domain.model

import androidx.annotation.DrawableRes
import dev.prodeva.weatherapplication.R

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int,
    @DrawableRes val backgroundImage : Int
) {
    data object ClearSky : WeatherType(
        weatherDesc = "Clear sky",
        iconRes = R.drawable.ic_sun_light,
        backgroundImage = R.drawable.ic_background_image_sunny
    )
    data object ThunderstormWithLightRain : WeatherType(
        weatherDesc = "Thunderstorm With Light Rain",
        iconRes = R.drawable.ic_thunderstorm_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object ThunderstormWithRain : WeatherType(
        weatherDesc = "Thunderstorm With Rain",
        iconRes = R.drawable.ic_thunderstorm_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object ThunderstormWithHeavyRain : WeatherType(
        weatherDesc = "Thunderstorm With Heavy Rain",
        iconRes = R.drawable.ic_thunderstorm_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object LightThunderstorm : WeatherType(
        weatherDesc = "Light Thunderstorm",
        iconRes = R.drawable.ic_thunderstorm_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object Thunderstorm : WeatherType(
        weatherDesc = "Thunderstorm",
        iconRes = R.drawable.ic_thunderstorm_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object HeavyThunderstorm : WeatherType(
        weatherDesc = "Heavy Thunderstorm",
        iconRes = R.drawable.ic_thunderstorm_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object RaggedThunderstorm : WeatherType(
        weatherDesc = "Ragged Thunderstorm",
        iconRes = R.drawable.ic_thunderstorm_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object ThunderstormWithLightDrizzle : WeatherType(
        weatherDesc = "Thunderstorm With Light Drizzle",
        iconRes = R.drawable.ic_thunderstorm_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object ThunderstormWithDrizzle : WeatherType(
        weatherDesc = "Thunderstorm With Drizzle",
        iconRes = R.drawable.ic_thunderstorm_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object ThunderstormWithHeavyDrizzle : WeatherType(
        weatherDesc = "Thunderstorm With Heavy Drizzle",
        iconRes = R.drawable.ic_thunderstorm_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object LightIntensityDrizzle : WeatherType(
        weatherDesc = "Light Intensity Drizzle",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object ModerateRain : WeatherType(
        weatherDesc = "Rainy",
        iconRes = R.drawable.ic_rainyday_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object Drizzle : WeatherType(
        weatherDesc = "Drizzle",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object HeavyIntensityDrizzle: WeatherType(
        weatherDesc = "Heavy Intensity Drizzle",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object LightIntensityDrizzleRain: WeatherType(
        weatherDesc = "Light Intensity Drizzle Rain",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object DrizzleRain: WeatherType(
        weatherDesc = "DrizzleRain",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object HeavyIntensityDrizzleRain: WeatherType(
        weatherDesc = "Heavy Intensity Drizzle Rain",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object ShowerRainAndDrizzle: WeatherType(
        weatherDesc = "Shower Rain And Drizzle",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object HeavyShowerRainAndDrizzle: WeatherType(
        weatherDesc = "Heavy Shower Rain And Drizzle",
        iconRes = R.drawable.ic_rainyday_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object ShowerDrizzle: WeatherType(
        weatherDesc = "Shower Drizzle",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object LightRain: WeatherType(
        weatherDesc = "Light Rain",
        iconRes = R.drawable.ic_rainyday_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object HeavyIntensityRain: WeatherType(
        weatherDesc = "Heavy Intensity Rain",
        iconRes = R.drawable.ic_rainyday_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object VeryHeavyRain: WeatherType(
        weatherDesc = "VeryHeavy Rain",
        iconRes = R.drawable.ic_rainyday_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object ExtremeRain: WeatherType(
        weatherDesc = "Extreme Rain",
        iconRes = R.drawable.ic_rainyday_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object FreezingRain: WeatherType(
        weatherDesc = "Freezing Rain",
        iconRes = R.drawable.ic_snow_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object ShowerRain: WeatherType(
        weatherDesc = "Shower Rain",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object HeavyIntensityShowerRain: WeatherType(
        weatherDesc = "Heavy Intensity Shower Rain",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object RaggedShowerRain: WeatherType(
        weatherDesc = "Ragged Shower Rain",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object LightSnow: WeatherType(
        weatherDesc = "Light Snow",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object Snow: WeatherType(
        weatherDesc = "Snow",
        iconRes = R.drawable.ic_snow_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object HeavySnow: WeatherType(
        weatherDesc = "Heavy Snow",
        iconRes = R.drawable.ic_snow_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object Sleet: WeatherType(
        weatherDesc = "Sleet",
        iconRes = R.drawable.ic_snow_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object LightShowerSleet: WeatherType(
        weatherDesc = "Light Shower Sleet",
        iconRes = R.drawable.ic_snow_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object ShowerSleet: WeatherType(
        weatherDesc = "Shower Sleet",
        iconRes = R.drawable.ic_snow_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object LightRainAndSnow: WeatherType(
        weatherDesc = "Light Rain And Snow",
        iconRes = R.drawable.ic_snow_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object LightShowerSnow: WeatherType(
        weatherDesc = "Light Shower Snow",
        iconRes = R.drawable.ic_snow_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object ShowerSnow: WeatherType(
        weatherDesc = "Shower Snow",
        iconRes = R.drawable.ic_snow_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object HeavyShowerSnow: WeatherType(
        weatherDesc = "Heavy Shower Snow",
        iconRes = R.drawable.ic_snow_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object Mist: WeatherType(
        weatherDesc = "Mist",
        iconRes = R.drawable.ic_heavy_wind_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object Smoke: WeatherType(
        weatherDesc = "Smoke",
        iconRes = R.drawable.ic_heavy_wind_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object Haze: WeatherType(
        weatherDesc = "Haze",
        iconRes = R.drawable.ic_heavy_wind_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object SandOrDustWhirls: WeatherType(
        weatherDesc = "Sand Or Dust Whirls",
        iconRes = R.drawable.ic_heavy_wind_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object Fog: WeatherType(
        weatherDesc = "Fog",
        iconRes = R.drawable.ic_heavy_wind_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object Sand: WeatherType(
        weatherDesc = "Sand",
        iconRes = R.drawable.ic_heavy_wind_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object Dust: WeatherType(
        weatherDesc = "Dust",
        iconRes = R.drawable.ic_heavy_wind_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object VolcanicAsh: WeatherType(
        weatherDesc = "Volcanic Ash",
        iconRes = R.drawable.ic_heavy_wind_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object Squalls: WeatherType(
        weatherDesc = "Squalls",
        iconRes = R.drawable.ic_heavy_wind_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object Tornado: WeatherType(
        weatherDesc = "Tornado",
        iconRes = R.drawable.ic_heavy_wind_light,
        backgroundImage = R.drawable.ic_background_image_forest
    )
    data object FewClouds: WeatherType(
        weatherDesc = "Few Clouds",
        iconRes = R.drawable.ic_partial_cloudy_light,
        backgroundImage = R.drawable.ic_background_image_cloudy
    )
    data object ScatteredClouds: WeatherType(
        weatherDesc = "Scattered Clouds",
        iconRes = R.drawable.ic_cloud_light,
        backgroundImage = R.drawable.ic_background_image_cloudy
    )
    data object BrokenClouds: WeatherType(
        weatherDesc = "Broken Clouds",
        iconRes = R.drawable.ic_mostly_cloudy_light,
        backgroundImage = R.drawable.ic_background_image_cloudy
    )
    data object OvercastClouds: WeatherType(
        weatherDesc = "Overcast Clouds",
        iconRes = R.drawable.ic_mostly_cloudy_light,
        backgroundImage = R.drawable.ic_background_image_cloudy
    )
    data object LightIntensityShowerRain: WeatherType(
        weatherDesc = "Light Intensity Shower Rain",
        iconRes = R.drawable.ic_rain_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )
    data object RainAndSnow: WeatherType(
        weatherDesc = "Rain And Snow",
        iconRes = R.drawable.ic_snow_light,
        backgroundImage = R.drawable.ic_background_image_rainy
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when(code) {
                200 -> ThunderstormWithLightRain
                201 -> ThunderstormWithRain
                202 -> ThunderstormWithHeavyRain
                210 -> LightThunderstorm
                211 -> Thunderstorm
                212 -> HeavyThunderstorm
                221 -> RaggedThunderstorm
                230 -> ThunderstormWithLightDrizzle
                231 -> ThunderstormWithDrizzle
                232 -> ThunderstormWithHeavyDrizzle
                300 -> LightIntensityDrizzle
                301 -> Drizzle
                302 -> HeavyIntensityDrizzle
                310 -> LightIntensityDrizzleRain
                311 -> DrizzleRain
                312 -> HeavyIntensityDrizzleRain
                313 -> ShowerRainAndDrizzle
                314 -> HeavyShowerRainAndDrizzle
                321 -> ShowerDrizzle
                500 -> LightRain
                501 -> ModerateRain
                502 -> HeavyIntensityRain
                503 -> VeryHeavyRain
                504 -> ExtremeRain
                511 -> FreezingRain
                520 -> LightIntensityShowerRain
                521 -> ShowerRain
                522 -> HeavyIntensityShowerRain
                531 -> RaggedShowerRain
                600 -> LightSnow
                601 -> Snow
                602 -> HeavySnow
                611 -> Sleet
                612 -> LightShowerSleet
                613 -> ShowerSleet
                615 -> LightRainAndSnow
                616 -> RainAndSnow
                620 -> LightShowerSnow
                621 -> ShowerSnow
                622 -> HeavyShowerSnow
                701 -> Mist
                711 -> Smoke
                721 -> Haze
                731 -> SandOrDustWhirls
                741 -> Fog
                751 -> Sand
                761 -> Dust
                762 -> VolcanicAsh
                771 -> Squalls
                781 -> Tornado
                800 -> ClearSky
                801 -> FewClouds
                802 -> ScatteredClouds
                803 -> BrokenClouds
                804 -> OvercastClouds
                else -> ClearSky
            }
        }
    }
}