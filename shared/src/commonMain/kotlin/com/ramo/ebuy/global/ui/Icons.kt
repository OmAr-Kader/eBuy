package com.ramo.ebuy.global.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject

@Composable
fun rememberSell(
    color: Color
): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "sell", defaultWidth = 40.0.dp, defaultHeight = 40.0.dp, viewportWidth = 40.0f, viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(21.458f, 36.375f)
                quadToRelative(-0.5f, 0f, -1f, -0.167f)
                quadToRelative(-0.5f, -0.166f, -0.916f, -0.583f)
                lineTo(4.375f, 20.458f)
                quadToRelative(-0.417f, -0.375f, -0.583f, -0.875f)
                quadToRelative(-0.167f, -0.5f, -0.167f, -1.041f)
                verticalLineTo(6.25f)
                quadToRelative(0f, -1.125f, 0.75f, -1.875f)
                reflectiveQuadToRelative(1.875f, -0.75f)
                horizontalLineToRelative(12.292f)
                quadToRelative(0.541f, 0f, 1.062f, 0.167f)
                quadToRelative(0.521f, 0.166f, 0.938f, 0.583f)
                lineToRelative(15.083f, 15.083f)
                quadToRelative(0.833f, 0.875f, 0.833f, 1.959f)
                quadToRelative(0f, 1.083f, -0.833f, 1.916f)
                lineTo(23.333f, 35.625f)
                quadToRelative(-0.375f, 0.375f, -0.854f, 0.563f)
                quadToRelative(-0.479f, 0.187f, -1.021f, 0.187f)
                close()
                moveToRelative(0.084f, -2.583f)
                lineTo(33.833f, 21.5f)
                lineTo(18.542f, 6.25f)
                horizontalLineTo(6.25f)
                verticalLineToRelative(12.292f)
                close()
                moveTo(10.5f, 12.667f)
                quadToRelative(0.917f, 0f, 1.562f, -0.646f)
                quadToRelative(0.646f, -0.646f, 0.646f, -1.563f)
                quadToRelative(0f, -0.875f, -0.646f, -1.52f)
                quadToRelative(-0.645f, -0.646f, -1.562f, -0.646f)
                quadToRelative(-0.875f, 0f, -1.521f, 0.646f)
                quadToRelative(-0.646f, 0.645f, -0.646f, 1.52f)
                quadToRelative(0f, 0.917f, 0.646f, 1.563f)
                quadToRelative(0.646f, 0.646f, 1.521f, 0.646f)
                close()
                moveTo(6.25f, 6.25f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberMic(
    color: Color,
): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "mic", defaultWidth = 40.0.dp, defaultHeight = 40.0.dp, viewportWidth = 40.0f, viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(20f, 22.542f)
                quadToRelative(-1.833f, 0f, -3.062f, -1.292f)
                quadToRelative(-1.23f, -1.292f, -1.23f, -3.167f)
                verticalLineTo(7.875f)
                quadToRelative(0f, -1.75f, 1.25f, -3f)
                reflectiveQuadTo(20f, 3.625f)
                quadToRelative(1.792f, 0f, 3.042f, 1.25f)
                quadToRelative(1.25f, 1.25f, 1.25f, 3f)
                verticalLineToRelative(10.208f)
                quadToRelative(0f, 1.875f, -1.23f, 3.167f)
                quadToRelative(-1.229f, 1.292f, -3.062f, 1.292f)
                close()
                moveToRelative(0f, -9.459f)
                close()
                moveToRelative(0f, 21.709f)
                quadToRelative(-0.542f, 0f, -0.917f, -0.396f)
                reflectiveQuadToRelative(-0.375f, -0.938f)
                verticalLineToRelative(-4.166f)
                quadToRelative(-4f, -0.459f, -6.791f, -3.209f)
                quadToRelative(-2.792f, -2.75f, -3.25f, -6.583f)
                quadToRelative(-0.084f, -0.583f, 0.312f, -1f)
                quadToRelative(0.396f, -0.417f, 1.021f, -0.417f)
                quadToRelative(0.458f, 0f, 0.833f, 0.355f)
                quadToRelative(0.375f, 0.354f, 0.459f, 0.854f)
                quadToRelative(0.458f, 3.166f, 2.916f, 5.312f)
                quadTo(16.667f, 26.75f, 20f, 26.75f)
                quadToRelative(3.333f, 0f, 5.792f, -2.146f)
                quadToRelative(2.458f, -2.146f, 2.916f, -5.312f)
                quadToRelative(0.084f, -0.542f, 0.459f, -0.875f)
                quadToRelative(0.375f, -0.334f, 0.875f, -0.334f)
                quadToRelative(0.583f, 0f, 0.979f, 0.417f)
                reflectiveQuadToRelative(0.312f, 1f)
                quadToRelative(-0.458f, 3.833f, -3.25f, 6.583f)
                quadToRelative(-2.791f, 2.75f, -6.75f, 3.209f)
                verticalLineToRelative(4.166f)
                quadToRelative(0f, 0.542f, -0.395f, 0.938f)
                quadToRelative(-0.396f, 0.396f, -0.938f, 0.396f)
                close()
                moveToRelative(0f, -14.875f)
                quadToRelative(0.75f, 0f, 1.208f, -0.542f)
                quadToRelative(0.459f, -0.542f, 0.459f, -1.292f)
                verticalLineTo(7.917f)
                quadToRelative(0f, -0.709f, -0.479f, -1.188f)
                quadToRelative(-0.48f, -0.479f, -1.188f, -0.479f)
                reflectiveQuadToRelative(-1.188f, 0.479f)
                quadToRelative(-0.479f, 0.479f, -0.479f, 1.146f)
                verticalLineToRelative(10.208f)
                quadToRelative(0f, 0.75f, 0.459f, 1.292f)
                quadToRelative(0.458f, 0.542f, 1.208f, 0.542f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberPhotoCamera(
    color: Color
): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "photo_camera", defaultWidth = 40.0.dp, defaultHeight = 40.0.dp, viewportWidth = 40.0f, viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(20f, 28.792f)
                quadToRelative(3f, 0f, 5.021f, -2.021f)
                reflectiveQuadToRelative(2.021f, -5.021f)
                quadToRelative(0f, -3f, -2.021f, -5.021f)
                reflectiveQuadTo(20f, 14.708f)
                quadToRelative(-3f, 0f, -5.021f, 2.021f)
                reflectiveQuadToRelative(-2.021f, 5.021f)
                quadToRelative(0f, 3f, 2.021f, 5.021f)
                reflectiveQuadTo(20f, 28.792f)
                close()
                moveTo(6.25f, 34.75f)
                quadToRelative(-1.083f, 0f, -1.854f, -0.792f)
                quadToRelative(-0.771f, -0.791f, -0.771f, -1.833f)
                verticalLineToRelative(-20.75f)
                quadToRelative(0f, -1.042f, 0.771f, -1.833f)
                quadToRelative(0.771f, -0.792f, 1.854f, -0.792f)
                horizontalLineToRelative(5.833f)
                lineToRelative(2.209f, -2.625f)
                quadToRelative(0.375f, -0.417f, 0.896f, -0.646f)
                quadToRelative(0.52f, -0.229f, 1.104f, -0.229f)
                horizontalLineToRelative(7.416f)
                quadToRelative(0.584f, 0f, 1.104f, 0.229f)
                quadToRelative(0.521f, 0.229f, 0.896f, 0.646f)
                lineToRelative(2.209f, 2.625f)
                horizontalLineToRelative(5.833f)
                quadToRelative(1.042f, 0f, 1.833f, 0.792f)
                quadToRelative(0.792f, 0.791f, 0.792f, 1.833f)
                verticalLineToRelative(20.75f)
                quadToRelative(0f, 1.042f, -0.792f, 1.833f)
                quadToRelative(-0.791f, 0.792f, -1.833f, 0.792f)
                close()
                moveToRelative(27.5f, -2.625f)
                verticalLineToRelative(-20.75f)
                horizontalLineTo(6.25f)
                verticalLineToRelative(20.75f)
                close()
                moveTo(20f, 21.75f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberLightning(
    color: Color,
): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Lightning", defaultWidth = 256.dp, defaultHeight = 256.dp, viewportWidth = 256f, viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(147.8f, 12.2f)
                curveToRelative(-0.7f, 1.3f, -20.1f, 31.5f, -43.1f, 67.4f)
                lineToRelative(-41.7f, 65.1f)
                lineToRelative(1.5f, 2.8f)
                lineToRelative(1.5f, 2.8f)
                lineToRelative(23.7f, 0.1f)
                curveToRelative(18.5f, 0.1f, 23.7f, 0.2f, 23.7f, 0.7f)
                curveToRelative(0f, 0.3f, -5.6f, 21.1f, -12.4f, 46.2f)
                lineToRelative(-12.3f, 45.7f)
                lineToRelative(3.2f, 1.6f)
                curveToRelative(2.8f, 1.4f, 3.3f, 1.5f, 3.9f, 0.9f)
                curveToRelative(0.4f, -0.4f, 21.1f, -29f, 46f, -63.5f)
                curveToRelative(24.9f, -34.5f, 46.6f, -64.5f, 48.1f, -66.7f)
                lineToRelative(2.8f, -3.9f)
                lineToRelative(-1.5f, -3f)
                lineToRelative(-1.5f, -3f)
                lineToRelative(-24f, -0.1f)
                lineToRelative(-24f, -0.1f)
                lineTo(149f, 59f)
                curveToRelative(3.9f, -25.5f, 7.1f, -46.4f, 7f, -46.5f)
                curveToRelative(-0.1f, -0.2f, -6.4f, -2.5f, -6.6f, -2.5f)
                curveTo(149.3f, 10f, 148.5f, 11f, 147.8f, 12.2f)
                close()
                moveTo(140.1f, 68.1f)
                curveToRelative(-3.2f, 21f, -6f, 38.7f, -6.1f, 39.4f)
                curveToRelative(-0.2f, 0.9f, 0.1f, 1.7f, 1.6f, 3.4f)
                lineToRelative(2f, 2.2f)
                lineToRelative(22.4f, 0.1f)
                lineToRelative(22.4f, 0.1f)
                lineToRelative(-40.1f, 55.5f)
                curveToRelative(-22f, 30.5f, -40.3f, 55.7f, -40.5f, 56f)
                curveToRelative(-0.3f, 0.3f, -0.3f, -0.1f, 0f, -0.9f)
                curveToRelative(0.3f, -0.8f, 4.7f, -17.2f, 9.9f, -36.5f)
                curveToRelative(5.2f, -19.3f, 9.7f, -36.1f, 10.1f, -37.3f)
                lineToRelative(0.7f, -2.2f)
                lineToRelative(-1.9f, -2.3f)
                lineToRelative(-1.9f, -2.4f)
                lineTo(96f, 143f)
                lineToRelative(-22.7f, -0.1f)
                lineToRelative(36.2f, -56.6f)
                curveToRelative(19.9f, -31.1f, 36.2f, -56.5f, 36.3f, -56.4f)
                curveTo(145.8f, 29.9f, 143.3f, 47.1f, 140.1f, 68.1f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberProductCategory(
    color: Color
): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "ProductCategory", defaultWidth = 256.dp, defaultHeight = 256.dp, viewportWidth = 256f, viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(66.4f, 10f)
                curveTo(35.3f, 10f, 10f, 35.3f, 10f, 66.4f)
                curveToRelative(0f, 31.1f, 25.3f, 56.4f, 56.4f, 56.4f)
                curveToRelative(31.1f, 0f, 56.4f, -25.3f, 56.4f, -56.4f)
                curveTo(122.8f, 35.3f, 97.6f, 10f, 66.4f, 10f)
                close()
                moveTo(66.4f, 112.6f)
                curveToRelative(-25.5f, 0f, -46.2f, -20.7f, -46.2f, -46.2f)
                reflectiveCurveTo(41f, 20.3f, 66.4f, 20.3f)
                curveToRelative(25.5f, 0f, 46.2f, 20.7f, 46.2f, 46.2f)
                reflectiveCurveTo(91.9f, 112.6f, 66.4f, 112.6f)
                close()
            }
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(189.6f, 122.9f)
                curveToRelative(31.1f, 0f, 56.4f, -25.3f, 56.4f, -56.4f)
                curveToRelative(0f, -31.1f, -25.3f, -56.4f, -56.4f, -56.4f)
                curveToRelative(-31.1f, 0f, -56.4f, 25.3f, -56.4f, 56.4f)
                curveTo(133.2f, 97.5f, 158.4f, 122.9f, 189.6f, 122.9f)
                close()
                moveTo(189.6f, 20.3f)
                curveToRelative(25.5f, 0f, 46.2f, 20.7f, 46.2f, 46.2f)
                curveToRelative(0f, 25.5f, -20.7f, 46.2f, -46.2f, 46.2f)
                curveToRelative(-25.5f, 0f, -46.2f, -20.7f, -46.2f, -46.2f)
                curveTo(143.4f, 41f, 164.1f, 20.3f, 189.6f, 20.3f)
                close()
            }
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(189.6f, 133.1f)
                curveToRelative(-31.1f, 0f, -56.4f, 25.3f, -56.4f, 56.4f)
                reflectiveCurveToRelative(25.3f, 56.4f, 56.4f, 56.4f)
                curveToRelative(31.1f, 0f, 56.4f, -25.3f, 56.4f, -56.4f)
                curveTo(246f, 158.4f, 220.7f, 133.1f, 189.6f, 133.1f)
                close()
                moveTo(189.6f, 235.7f)
                curveToRelative(-25.5f, 0f, -46.2f, -20.7f, -46.2f, -46.2f)
                curveToRelative(0f, -25.5f, 20.7f, -46.2f, 46.2f, -46.2f)
                reflectiveCurveToRelative(46.2f, 20.7f, 46.2f, 46.2f)
                curveTo(235.7f, 215f, 215f, 235.7f, 189.6f, 235.7f)
                close()
            }
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(66.4f, 133.1f)
                curveToRelative(-31.1f, 0f, -56.4f, 25.3f, -56.4f, 56.4f)
                reflectiveCurveTo(35.3f, 246f, 66.4f, 246f)
                curveToRelative(31.1f, 0f, 56.4f, -25.3f, 56.4f, -56.4f)
                curveTo(122.8f, 158.5f, 97.6f, 133.1f, 66.4f, 133.1f)
                close()
                moveTo(66.4f, 235.7f)
                curveToRelative(-25.5f, 0f, -46.2f, -20.7f, -46.2f, -46.2f)
                curveToRelative(0f, -25.5f, 20.7f, -46.2f, 46.2f, -46.2f)
                curveToRelative(25.5f, 0f, 46.2f, 20.7f, 46.2f, 46.2f)
                curveTo(112.6f, 215f, 91.9f, 235.7f, 66.4f, 235.7f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberFavorite(
    color: Color
): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Favorite", defaultWidth = 256.dp, defaultHeight = 256.dp, viewportWidth = 256f, viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(245.2f, 82.8f)
                curveToRelative(-4.9f, -35.2f, -35.7f, -59.2f, -68.4f, -59.2f)
                curveToRelative(-10f, 0f, -20.2f, 2.3f, -29.9f, 7.1f)
                curveToRelative(-6.8f, 3.4f, -12.9f, 8.3f, -19.7f, 12.7f)
                curveToRelative(0f, 0f, -0.4f, -0.3f, -0.8f, -0.7f)
                curveTo(113f, 30.1f, 96.1f, 23.6f, 79f, 23.6f)
                curveToRelative(-11.8f, 0f, -23.7f, 3.1f, -34.6f, 9.4f)
                curveTo(19.4f, 47.5f, 6.1f, 76f, 11f, 104.4f)
                curveToRelative(2.8f, 16.3f, 10.8f, 29.8f, 22.3f, 41.4f)
                curveToRelative(21.7f, 21.9f, 59.3f, 59.7f, 80f, 80.4f)
                curveToRelative(4.1f, 4.1f, 9.4f, 6.1f, 14.8f, 6.1f)
                curveToRelative(5.3f, 0f, 10.7f, -2f, 14.7f, -6.1f)
                curveToRelative(21.2f, -21.3f, 60.3f, -60.5f, 82.9f, -83.8f)
                curveTo(241.5f, 126.1f, 248.4f, 105.8f, 245.2f, 82.8f)
                close()
                moveTo(213.4f, 130.5f)
                curveToRelative(-26.3f, 27.1f, -73.5f, 74.4f, -82.7f, 83.6f)
                curveToRelative(-0.9f, 0.9f, -2f, 1.1f, -2.7f, 1.1f)
                reflectiveCurveToRelative(-1.8f, -0.2f, -2.7f, -1.2f)
                curveToRelative(-20.7f, -20.8f, -58.2f, -58.5f, -80f, -80.4f)
                curveToRelative(-9.8f, -9.8f, -15.5f, -20.4f, -17.5f, -32.2f)
                curveToRelative(-3.7f, -21.2f, 6.4f, -42.7f, 25.1f, -53.5f)
                curveToRelative(8f, -4.6f, 17.1f, -7.1f, 26.1f, -7.1f)
                curveToRelative(13.2f, 0f, 25.9f, 5.1f, 35.8f, 14.4f)
                curveToRelative(4.4f, 4.1f, 8.7f, 5.4f, 12.4f, 5.4f)
                curveToRelative(4.7f, 0f, 8.3f, -2.1f, 9.4f, -2.8f)
                curveToRelative(2.3f, -1.5f, 4.6f, -3.1f, 6.7f, -4.6f)
                curveToRelative(4f, -2.8f, 7.7f, -5.4f, 11.3f, -7.2f)
                curveToRelative(7f, -3.5f, 14.5f, -5.3f, 22.3f, -5.3f)
                curveToRelative(25.9f, 0f, 48.1f, 19.1f, 51.6f, 44.4f)
                curveTo(230.8f, 102.8f, 225.9f, 117.6f, 213.4f, 130.5f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberHome(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "home", defaultWidth = 40.0.dp, defaultHeight = 40.0.dp, viewportWidth = 40.0f, viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(9.542f, 32.125f)
                horizontalLineToRelative(5.75f)
                verticalLineToRelative(-10.25f)
                horizontalLineToRelative(9.416f)
                verticalLineToRelative(10.25f)
                horizontalLineToRelative(5.75f)
                verticalLineTo(16.417f)
                lineTo(20f, 8.583f)
                lineTo(9.542f, 16.417f)
                close()
                moveToRelative(0f, 2.625f)
                quadToRelative(-1.084f, 0f, -1.855f, -0.771f)
                quadToRelative(-0.77f, -0.771f, -0.77f, -1.854f)
                verticalLineTo(16.417f)
                quadToRelative(0f, -0.625f, 0.271f, -1.188f)
                quadToRelative(0.27f, -0.562f, 0.77f, -0.937f)
                lineToRelative(10.459f, -7.834f)
                quadToRelative(0.375f, -0.25f, 0.771f, -0.375f)
                quadToRelative(0.395f, -0.125f, 0.812f, -0.125f)
                quadToRelative(0.417f, 0f, 0.812f, 0.125f)
                quadToRelative(0.396f, 0.125f, 0.771f, 0.375f)
                lineToRelative(10.459f, 7.834f)
                quadToRelative(0.5f, 0.375f, 0.77f, 0.937f)
                quadToRelative(0.271f, 0.563f, 0.271f, 1.188f)
                verticalLineToRelative(15.708f)
                quadToRelative(0f, 1.083f, -0.771f, 1.854f)
                quadToRelative(-0.77f, 0.771f, -1.854f, 0.771f)
                horizontalLineToRelative(-8.375f)
                verticalLineTo(24.5f)
                horizontalLineToRelative(-4.166f)
                verticalLineToRelative(10.25f)
                close()
                moveTo(20f, 20.333f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberPersonal(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Personal",
            defaultWidth = 256.dp,
            defaultHeight = 256.dp,
            viewportWidth = 256f,
            viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(10f, 128f)
                curveToRelative(0f, 65.2f, 52.8f, 118f, 118f, 118f)
                curveToRelative(65.2f, 0f, 118f, -52.8f, 118f, -118f)
                curveToRelative(0f, -65.2f, -52.8f, -118f, -118f, -118f)
                curveTo(62.8f, 10f, 10f, 62.8f, 10f, 128f)
                lineTo(10f, 128f)
                lineTo(10f, 128f)
                close()
                moveTo(21.2f, 128f)
                curveToRelative(0f, -55.1f, 52f, -106.8f, 106.8f, -106.8f)
                curveToRelative(59.7f, 0f, 106.8f, 54.4f, 106.8f, 106.8f)
                curveToRelative(0f, 24.3f, -8.5f, 47.9f, -20.2f, 64.9f)
                curveToRelative(-7.4f, -28.6f, -31f, -51.9f, -62.2f, -60.8f)
                curveToRelative(14.8f, -8.5f, 26.2f, -25.1f, 26.2f, -43.4f)
                curveToRelative(0f, -29.6f, -23.4f, -50.6f, -50.6f, -50.6f)
                curveToRelative(-28.7f, 0f, -50.6f, 23.4f, -50.6f, 50.6f)
                curveToRelative(0f, 18.3f, 11.4f, 35f, 26.2f, 43.4f)
                curveToRelative(-31.2f, 8.9f, -56.4f, 32f, -62.2f, 60.8f)
                curveTo(29.7f, 176.1f, 21.2f, 152.3f, 21.2f, 128f)
                lineTo(21.2f, 128f)
                lineTo(21.2f, 128f)
                close()
                moveTo(206.7f, 201f)
                curveToRelative(-18f, 19.2f, -54.5f, 33.4f, -78.7f, 33.7f)
                curveToRelative(-29.6f, 0.5f, -64.2f, -18.1f, -78.7f, -33.7f)
                lineToRelative(0.6f, 0.7f)
                curveToRelative(4.8f, -31.6f, 38f, -62.5f, 78.1f, -62.5f)
                curveToRelative(40.1f, 0f, 72.3f, 32.1f, 78.1f, 62.5f)
                horizontalLineToRelative(1f)
                lineTo(206.7f, 201f)
                lineTo(206.7f, 201f)
                close()
                moveTo(88.7f, 89.3f)
                curveToRelative(0f, -21.7f, 17.6f, -40f, 39.3f, -40f)
                curveToRelative(21.7f, 0f, 39.3f, 18.3f, 39.3f, 40f)
                curveToRelative(0f, 21.7f, -17.6f, 38.7f, -39.3f, 38.7f)
                curveTo(106.3f, 128f, 88.7f, 111.1f, 88.7f, 89.3f)
                lineTo(88.7f, 89.3f)
                lineTo(88.7f, 89.3f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberSearch(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "search",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(31.917f, 33.792f)
                lineToRelative(-9.75f, -9.75f)
                quadToRelative(-1.209f, 1.041f, -2.855f, 1.625f)
                quadToRelative(-1.645f, 0.583f, -3.479f, 0.583f)
                quadToRelative(-4.458f, 0f, -7.521f, -3.083f)
                quadToRelative(-3.062f, -3.084f, -3.062f, -7.459f)
                reflectiveQuadToRelative(3.062f, -7.437f)
                quadToRelative(3.063f, -3.063f, 7.48f, -3.063f)
                quadToRelative(4.375f, 0f, 7.437f, 3.063f)
                quadToRelative(3.063f, 3.062f, 3.063f, 7.479f)
                quadToRelative(0f, 1.75f, -0.584f, 3.396f)
                quadToRelative(-0.583f, 1.646f, -1.666f, 3.021f)
                lineToRelative(9.833f, 9.75f)
                quadToRelative(0.375f, 0.375f, 0.375f, 0.916f)
                quadToRelative(0f, 0.542f, -0.417f, 0.959f)
                quadToRelative(-0.416f, 0.375f, -0.979f, 0.375f)
                quadToRelative(-0.562f, 0f, -0.937f, -0.375f)
                close()
                moveTo(15.792f, 23.625f)
                quadToRelative(3.291f, 0f, 5.583f, -2.313f)
                quadToRelative(2.292f, -2.312f, 2.292f, -5.604f)
                quadToRelative(0f, -3.291f, -2.292f, -5.583f)
                quadToRelative(-2.292f, -2.292f, -5.583f, -2.292f)
                quadToRelative(-3.292f, 0f, -5.604f, 2.313f)
                quadToRelative(-2.313f, 2.312f, -2.313f, 5.562f)
                quadToRelative(0f, 3.292f, 2.313f, 5.604f)
                quadToRelative(2.312f, 2.313f, 5.604f, 2.313f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberNotifications(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "notifications",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(8.167f, 31.625f)
                quadToRelative(-0.542f, 0f, -0.938f, -0.396f)
                quadToRelative(-0.396f, -0.396f, -0.396f, -0.937f)
                quadToRelative(0f, -0.542f, 0.396f, -0.938f)
                quadToRelative(0.396f, -0.396f, 0.938f, -0.396f)
                horizontalLineToRelative(2.125f)
                verticalLineTo(16.542f)
                quadToRelative(0f, -3.375f, 2.041f, -6.084f)
                quadToRelative(2.042f, -2.708f, 5.334f, -3.416f)
                verticalLineTo(5.875f)
                quadToRelative(0f, -1f, 0.666f, -1.625f)
                quadTo(19f, 3.625f, 20f, 3.625f)
                quadToRelative(0.958f, 0f, 1.646f, 0.625f)
                quadToRelative(0.687f, 0.625f, 0.687f, 1.625f)
                verticalLineToRelative(1.167f)
                quadToRelative(3.292f, 0.708f, 5.375f, 3.416f)
                quadToRelative(2.084f, 2.709f, 2.084f, 6.084f)
                verticalLineToRelative(12.416f)
                horizontalLineToRelative(2.041f)
                quadToRelative(0.542f, 0f, 0.938f, 0.396f)
                quadToRelative(0.396f, 0.396f, 0.396f, 0.938f)
                quadToRelative(0f, 0.541f, -0.396f, 0.937f)
                reflectiveQuadToRelative(-0.938f, 0.396f)
                close()
                moveTo(20f, 19.375f)
                close()
                moveToRelative(0f, 17.083f)
                quadToRelative(-1.333f, 0f, -2.312f, -0.958f)
                quadToRelative(-0.98f, -0.958f, -0.98f, -2.292f)
                horizontalLineToRelative(6.584f)
                quadToRelative(0f, 1.334f, -0.959f, 2.292f)
                quadToRelative(-0.958f, 0.958f, -2.333f, 0.958f)
                close()
                moveToRelative(-7.083f, -7.5f)
                horizontalLineToRelative(14.208f)
                verticalLineTo(16.583f)
                quadToRelative(0f, -3.041f, -2.042f, -5.104f)
                quadToRelative(-2.041f, -2.062f, -5.041f, -2.062f)
                quadToRelative(-2.959f, 0f, -5.042f, 2.083f)
                quadToRelative(-2.083f, 2.083f, -2.083f, 5.042f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberMessage(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Message",
            defaultWidth = 256.dp,
            defaultHeight = 256.dp,
            viewportWidth = 256f,
            viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(10.2f, 42.2f)
                curveTo(10f, 42.6f, 10f, 81.3f, 10f, 128.5f)
                lineToRelative(0.1f, 85.6f)
                lineToRelative(117.8f, 0.1f)
                lineToRelative(117.8f, 0.1f)
                lineToRelative(0.1f, -81.4f)
                curveToRelative(0f, -44.8f, 0.1f, -82.5f, 0.1f, -83.9f)
                verticalLineToRelative(-2.4f)
                lineToRelative(-2.4f, -0.1f)
                lineToRelative(-2.5f, -0.1f)
                verticalLineTo(44f)
                verticalLineToRelative(-2.3f)
                horizontalLineTo(125.7f)
                curveTo(33.9f, 41.7f, 10.3f, 41.8f, 10.2f, 42.2f)
                close()
                moveTo(218.3f, 63.3f)
                curveToRelative(-6.5f, 6.5f, -23.7f, 24.1f, -38.3f, 39f)
                curveToRelative(-14.6f, 14.9f, -28f, 28.6f, -29.9f, 30.3f)
                curveToRelative(-10.4f, 10.2f, -20.8f, 12.4f, -31.9f, 6.5f)
                curveToRelative(-2.5f, -1.3f, -4.9f, -3.2f, -9.6f, -7.8f)
                curveToRelative(-13.3f, -12.9f, -75.7f, -73.5f, -78.8f, -76.6f)
                lineToRelative(-3.3f, -3.2f)
                horizontalLineToRelative(101.8f)
                horizontalLineToRelative(101.8f)
                lineTo(218.3f, 63.3f)
                close()
                moveTo(56f, 93.1f)
                curveToRelative(19.7f, 19.1f, 35.8f, 35f, 35.8f, 35.1f)
                curveToRelative(0f, 0.4f, -71.5f, 69.4f, -72.1f, 69.6f)
                curveToRelative(-0.2f, 0.1f, -0.4f, -26.9f, -0.4f, -69.9f)
                curveToRelative(0f, -40.9f, 0.2f, -70f, 0.4f, -69.9f)
                curveTo(19.9f, 58.2f, 36.3f, 74f, 56f, 93.1f)
                close()
                moveTo(236.3f, 162.6f)
                lineToRelative(-0.1f, 35f)
                lineTo(201.9f, 163f)
                lineToRelative(-34.3f, -34.7f)
                lineToRelative(34.3f, -34.9f)
                lineToRelative(34.3f, -34.9f)
                lineToRelative(0.1f, 34.6f)
                curveTo(236.4f, 112.1f, 236.4f, 143.4f, 236.3f, 162.6f)
                close()
                moveTo(104.7f, 140.4f)
                curveToRelative(4.9f, 4.6f, 9.4f, 7.4f, 15.1f, 9.5f)
                curveToRelative(3.7f, 1.3f, 4.6f, 1.5f, 9.9f, 1.5f)
                curveToRelative(5.3f, 0f, 6.2f, -0.1f, 10.2f, -1.5f)
                curveToRelative(6.9f, -2.4f, 11.2f, -5.1f, 17.5f, -11.3f)
                lineToRelative(3.6f, -3.6f)
                lineToRelative(32.2f, 32.5f)
                curveToRelative(17.7f, 17.9f, 33.1f, 33.5f, 34.2f, 34.7f)
                lineToRelative(2.1f, 2.2f)
                horizontalLineTo(128f)
                horizontalLineTo(26.6f)
                lineToRelative(7.2f, -7f)
                curveToRelative(4f, -3.8f, 20.2f, -19.5f, 36f, -34.8f)
                curveToRelative(27.8f, -26.9f, 28.8f, -27.8f, 29.7f, -27.1f)
                curveTo(100f, 136.1f, 102.4f, 138.2f, 104.7f, 140.4f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberRetry(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Retry",
            defaultWidth = 256.dp,
            defaultHeight = 256.dp,
            viewportWidth = 256f,
            viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(244.7f, 23.5f)
                curveToRelative(-0.4f, -0.5f, -1f, -0.9f, -1.6f, -1.2f)
                curveToRelative(-1.8f, -0.9f, -3.9f, -0.5f, -5.4f, 0.9f)
                lineToRelative(-23f, 20.6f)
                curveTo(184.8f, 13.7f, 139.8f, 0.4f, 96.1f, 13.2f)
                curveToRelative(-63.4f, 18.5f, -99.8f, 85f, -81.3f, 148.4f)
                curveToRelative(18.5f, 63.4f, 85f, 99.8f, 148.4f, 81.3f)
                curveToRelative(41.1f, -12f, 70.9f, -44.1f, 81.7f, -82.5f)
                curveToRelative(0.4f, -1.3f, 0.3f, -2.8f, 0.3f, -4.3f)
                curveToRelative(0f, -8.6f, -7f, -15.5f, -15.5f, -15.5f)
                curveToRelative(-6.9f, 0f, -12.9f, 4.5f, -14.9f, 10.7f)
                curveToRelative(-7.7f, 28.4f, -29.6f, 52.3f, -59.9f, 61.1f)
                curveToRelative(-46.4f, 13.5f, -94.9f, -13.1f, -108.4f, -59.4f)
                curveTo(32.9f, 106.6f, 59.5f, 58f, 105.8f, 44.5f)
                curveToRelative(31.1f, -9.1f, 63.1f, -0.1f, 85f, 20.8f)
                lineToRelative(-23.6f, 21.2f)
                curveToRelative(-1.5f, 1.3f, -2.1f, 3.4f, -1.4f, 5.3f)
                curveToRelative(0.7f, 1.9f, 2.4f, 3.2f, 4.4f, 3.3f)
                lineToRelative(70.5f, 8f)
                curveToRelative(2.7f, 0.1f, 5.1f, -2f, 5.2f, -4.7f)
                lineToRelative(0.1f, -71.2f)
                curveTo(246.1f, 25.8f, 245.6f, 24.5f, 244.7f, 23.5f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberPurchaseManagement(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "PurchaseManagement",
            defaultWidth = 256.dp,
            defaultHeight = 256.dp,
            viewportWidth = 256f,
            viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(128f, 246f)
                curveToRelative(-1f, 0f, -2f, -0.3f, -2.9f, -0.8f)
                lineToRelative(-98.5f, -57.4f)
                curveToRelative(-1.8f, -1.1f, -2.9f, -3f, -2.9f, -5f)
                verticalLineTo(73.2f)
                curveToRelative(0f, -2f, 1.1f, -3.9f, 2.9f, -5f)
                lineToRelative(97.7f, -57.4f)
                curveToRelative(1.8f, -1.1f, 4.1f, -1.1f, 5.9f, 0f)
                lineToRelative(99f, 58.6f)
                curveToRelative(1.8f, 1.1f, 2.9f, 3f, 2.9f, 5f)
                verticalLineToRelative(111.9f)
                curveToRelative(0f, 2.1f, -1.2f, 4.1f, -3f, 5.1f)
                lineToRelative(-98.4f, 53.8f)
                curveTo(129.9f, 245.8f, 129f, 246f, 128f, 246f)
                lineTo(128f, 246f)
                close()
                moveTo(32.6f, 181.1f)
                lineToRelative(95.5f, 55.7f)
                lineToRelative(95.3f, -52.1f)
                verticalLineTo(76.2f)
                lineToRelative(-96.1f, -56.9f)
                lineTo(32.6f, 74.9f)
                verticalLineTo(181.1f)
                lineTo(32.6f, 181.1f)
                close()
            }
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(130.2f, 132.5f)
                lineToRelative(-4.3f, -7.7f)
                lineToRelative(100.5f, -56.3f)
                lineToRelative(4.3f, 7.7f)
                lineTo(130.2f, 132.5f)
            }
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(125.8f, 132.5f)
                lineTo(25.4f, 74.9f)
                lineToRelative(4.4f, -7.6f)
                lineToRelative(100.5f, 57.5f)
                lineTo(125.8f, 132.5f)
            }
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(123.6f, 128.6f)
                horizontalLineToRelative(8.8f)
                verticalLineToRelative(113.2f)
                horizontalLineToRelative(-8.8f)
                verticalLineTo(128.6f)
                close()
            }
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(176.8f, 103.9f)
                lineTo(76f, 45.7f)
                lineToRelative(4.4f, -7.7f)
                lineToRelative(100.8f, 58.3f)
                lineTo(176.8f, 103.9f)
            }
        }.build()
    }
}

@Composable
fun rememberBid(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Bid",
            defaultWidth = 256.dp,
            defaultHeight = 256.dp,
            viewportWidth = 256f,
            viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(119.3f, 134.7f)
                curveToRelative(-2.8f, 2.9f, -5.5f, 5.8f, -8.2f, 8.5f)
                curveToRelative(-2.4f, 2.5f, -4.9f, 4.9f, -7.3f, 7.4f)
                curveToRelative(-0.8f, 0.8f, -1.3f, 0.7f, -2f, 0f)
                curveToRelative(-18.9f, -19f, -37.7f, -37.9f, -56.6f, -56.9f)
                curveToRelative(-0.5f, -0.5f, -0.8f, -1f, -1.2f, -1.5f)
                curveToRelative(19.3f, -19.3f, 38.5f, -38.5f, 57.7f, -57.8f)
                curveToRelative(1f, -1f, 1.3f, -0.9f, 2.2f, 0f)
                curveTo(122.5f, 53.2f, 141.3f, 72f, 160f, 90.8f)
                curveToRelative(1.5f, 1.5f, 1.5f, 1.6f, 0f, 3.1f)
                curveToRelative(-5f, 5f, -9.9f, 10f, -15f, 15.2f)
                curveToRelative(2.1f, 2.2f, 4.4f, 4.6f, 6.6f, 6.9f)
                curveToRelative(18.4f, 18.5f, 36.7f, 37f, 55.1f, 55.5f)
                curveToRelative(11.1f, 11.1f, 22.1f, 22.2f, 33.1f, 33.4f)
                curveToRelative(3.3f, 3.3f, 5.3f, 7.3f, 6f, 12f)
                curveToRelative(1.2f, 8.3f, -4.6f, 15.8f, -10.9f, 18.4f)
                curveToRelative(-3.3f, 1.4f, -6.7f, 1.6f, -10.1f, 1.2f)
                curveToRelative(-3.4f, -0.5f, -6.3f, -2.2f, -8.8f, -4.7f)
                curveToRelative(-18.2f, -18.2f, -36.5f, -36.4f, -54.7f, -54.6f)
                curveToRelative(-13.7f, -13.7f, -27.3f, -27.4f, -40.9f, -41.1f)
                curveTo(120.2f, 135.6f, 119.9f, 135.3f, 119.3f, 134.7f)
                close()
            }
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(36f, 220.5f)
                curveToRelative(-1.2f, -0.9f, -2.3f, -1.8f, -3.5f, -2.8f)
                curveToRelative(-6.4f, -5.3f, -5.8f, -16.3f, 2.4f, -20.1f)
                curveToRelative(2.4f, -1.1f, 5.4f, -1.4f, 8.1f, -1.4f)
                curveToRelative(24.6f, -0.1f, 49.1f, -0.1f, 73.7f, 0f)
                curveToRelative(4.6f, 0f, 9f, 1.4f, 11.6f, 5.8f)
                curveToRelative(3.3f, 5.6f, 2.2f, 12.5f, -3.8f, 16.3f)
                curveToRelative(-1.1f, 0.7f, -2.2f, 1.4f, -3.3f, 2.1f)
                curveToRelative(0f, 0.2f, 0.1f, 0.4f, 0.2f, 0.6f)
                curveToRelative(0.5f, 0f, 1f, 0f, 1.5f, 0f)
                curveToRelative(4.7f, 0f, 9.4f, 0.1f, 14.1f, 0f)
                curveToRelative(6f, -0.2f, 11.1f, 5.5f, 11.3f, 11.1f)
                curveToRelative(0.2f, 5.6f, -3.2f, 9.7f, -7.3f, 11.6f)
                curveToRelative(-1.3f, 0.6f, -2.9f, 0.9f, -4.4f, 0.9f)
                curveToRelative(-5.9f, 0.1f, -11.8f, 0.1f, -17.7f, 0.1f)
                curveToRelative(-32f, 0f, -63.9f, 0f, -95.9f, 0f)
                curveToRelative(-3.7f, 0f, -6.8f, -1f, -9.5f, -3.4f)
                curveToRelative(-4.3f, -3.9f, -4.6f, -10.2f, -1.8f, -14.9f)
                curveToRelative(2.2f, -3.5f, 5.3f, -5.4f, 9.4f, -5.4f)
                curveToRelative(4.8f, 0f, 9.6f, 0f, 14.5f, 0f)
                curveTo(35.8f, 220.7f, 35.9f, 220.6f, 36f, 220.5f)
                close()
            }
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(33.5f, 101.1f)
                curveToRelative(0.6f, 0.6f, 1.1f, 1f, 1.6f, 1.5f)
                curveToRelative(19f, 19f, 38f, 38.1f, 57f, 57.1f)
                curveToRelative(1.1f, 1.1f, 1.1f, 1.8f, 0f, 2.8f)
                curveToRelative(-2.9f, 2.6f, -5.7f, 5.2f, -8.5f, 7.8f)
                curveToRelative(-3.8f, 3.6f, -11.3f, 2.9f, -15f, -0.8f)
                curveToRelative(-12.9f, -13.1f, -26f, -26f, -38.9f, -39f)
                curveToRelative(-2f, -2f, -4f, -4.1f, -5.8f, -6.2f)
                curveToRelative(-2.8f, -3.4f, -2.5f, -10f, 0.4f, -13.4f)
                curveTo(27.2f, 107.5f, 30.4f, 104.4f, 33.5f, 101.1f)
                close()
            }
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(170.7f, 82.7f)
                curveToRelative(-2.8f, -2.8f, -5.9f, -5.9f, -9.1f, -9.1f)
                curveToRelative(-16.3f, -16.3f, -32.5f, -32.7f, -48.8f, -49f)
                curveToRelative(-1.2f, -1.2f, -1.2f, -1.8f, 0.1f, -2.9f)
                curveToRelative(2.6f, -2.2f, 5.1f, -4.5f, 7.5f, -6.9f)
                curveToRelative(4.9f, -5f, 11.9f, -4f, 16.2f, 0.3f)
                curveToRelative(14.3f, 14.3f, 28.5f, 28.6f, 42.8f, 42.9f)
                curveToRelative(2.4f, 2.4f, 3.6f, 5.4f, 3.5f, 8.6f)
                curveToRelative(-0.1f, 3.1f, -1.4f, 6.1f, -3.7f, 8.3f)
                curveTo(176.5f, 77.5f, 173.6f, 80f, 170.7f, 82.7f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberPayment(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Payment",
            defaultWidth = 256.dp,
            defaultHeight = 256.dp,
            viewportWidth = 256f,
            viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(218.9f, 168.8f)
                curveToRelative(-3.3f, 0f, -6f, 2.7f, -6f, 6f)
                lineToRelative(0f, 0f)
                verticalLineToRelative(0f)
                verticalLineToRelative(0f)
                verticalLineToRelative(30.3f)
                curveToRelative(0f, 6.6f, -5.4f, 12f, -12f, 12f)
                horizontalLineTo(86.4f)
                horizontalLineToRelative(0f)
                horizontalLineTo(33.9f)
                curveToRelative(-6.6f, 0f, -12f, -5.3f, -12f, -12f)
                verticalLineTo(50.8f)
                curveToRelative(0f, -6.6f, 5.4f, -12f, 12f, -12f)
                horizontalLineToRelative(167f)
                curveToRelative(6.6f, 0f, 12f, 5.3f, 12f, 12f)
                verticalLineTo(83f)
                verticalLineToRelative(0f)
                curveToRelative(0f, 3.3f, 2.7f, 6f, 6f, 6f)
                curveToRelative(3.3f, 0f, 6f, -2.7f, 6f, -6f)
                verticalLineToRelative(0f)
                verticalLineTo(49.6f)
                curveToRelative(0f, -12.6f, -10.2f, -22.8f, -22.8f, -22.8f)
                horizontalLineTo(32.8f)
                curveTo(20.2f, 26.9f, 10f, 37.1f, 10f, 49.6f)
                verticalLineToRelative(156.7f)
                curveToRelative(0f, 12.6f, 10.2f, 22.8f, 22.8f, 22.8f)
                horizontalLineToRelative(169.4f)
                curveToRelative(12.6f, 0f, 22.8f, -10.2f, 22.8f, -22.8f)
                verticalLineToRelative(-31.6f)
                curveTo(224.9f, 171.5f, 222.2f, 168.8f, 218.9f, 168.8f)
                lineTo(218.9f, 168.8f)
                close()
                moveTo(223.2f, 97.5f)
                horizontalLineTo(136f)
                curveToRelative(-11.8f, 0f, -21.4f, 9f, -22.5f, 20.5f)
                curveToRelative(-0.1f, 0.2f, -0.2f, 0.5f, -0.2f, 1f)
                verticalLineToRelative(19f)
                curveToRelative(0f, 12.6f, 10.2f, 22.8f, 22.8f, 22.8f)
                horizontalLineToRelative(87.2f)
                curveToRelative(12.6f, 0f, 22.8f, -10.2f, 22.8f, -22.8f)
                verticalLineToRelative(-16f)
                lineToRelative(0f, 0f)
                verticalLineToRelative(-1.7f)
                curveTo(246f, 107.6f, 235.8f, 97.5f, 223.2f, 97.5f)
                lineTo(223.2f, 97.5f)
                close()
                moveTo(234f, 136.7f)
                curveToRelative(0f, 6.6f, -5.4f, 12f, -12f, 12f)
                horizontalLineToRelative(-76.6f)
                horizontalLineToRelative(0f)
                horizontalLineToRelative(-8.2f)
                curveToRelative(-6.6f, 0f, -12f, -5.3f, -12f, -12f)
                verticalLineToRelative(-15.3f)
                curveToRelative(0f, -6.6f, 5.4f, -12f, 12f, -12f)
                horizontalLineToRelative(84.8f)
                curveToRelative(6.6f, 0f, 12f, 5.4f, 12f, 12f)
                verticalLineTo(136.7f)
                lineTo(234f, 136.7f)
                close()
                moveTo(215.2f, 121.6f)
                curveToRelative(-4f, 0f, -7.3f, 3.3f, -7.3f, 7.3f)
                curveToRelative(0f, 4f, 3.3f, 7.3f, 7.3f, 7.3f)
                curveToRelative(4f, 0f, 7.3f, -3.3f, 7.3f, -7.3f)
                curveTo(222.5f, 124.9f, 219.2f, 121.6f, 215.2f, 121.6f)
                lineTo(215.2f, 121.6f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberSetting(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Setting",
            defaultWidth = 256.dp,
            defaultHeight = 256.dp,
            viewportWidth = 256f,
            viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(117.3f, 4.5f)
                curveToRelative(-6.6f, 0.6f, -14.6f, 2f, -16.6f, 3f)
                curveTo(99.4f, 8.1f, 98f, 9.2f, 97.5f, 10f)
                curveToRelative(-0.6f, 0.8f, -2f, 5.4f, -3.3f, 10.2f)
                curveToRelative(-1.3f, 4.8f, -2.6f, 9f, -2.9f, 9.2f)
                curveToRelative(-0.2f, 0.2f, -2.9f, 1.4f, -5.8f, 2.8f)
                curveTo(79.2f, 34.9f, 71f, 39.7f, 65.3f, 44f)
                curveTo(63f, 45.7f, 60.9f, 47f, 60.7f, 47f)
                curveToRelative(-0.3f, 0f, -4.2f, -1f, -8.6f, -2.2f)
                curveToRelative(-11.5f, -3.1f, -13f, -3f, -17.4f, 1.8f)
                curveToRelative(-6.3f, 6.8f, -13.1f, 17.2f, -17.9f, 27.1f)
                curveToRelative(-6f, 12.4f, -7.7f, 18.6f, -6f, 21.9f)
                curveToRelative(0.4f, 0.7f, 3.6f, 4.2f, 7.3f, 7.9f)
                lineToRelative(6.6f, 6.7f)
                lineToRelative(-0.6f, 4.9f)
                curveToRelative(-0.8f, 6.3f, -0.8f, 19.5f, 0f, 25.8f)
                lineToRelative(0.6f, 4.8f)
                lineToRelative(-6.9f, 7f)
                curveToRelative(-9.4f, 9.5f, -9.4f, 9.5f, -4.7f, 21.3f)
                curveToRelative(5.6f, 14.2f, 18.3f, 33.9f, 24.6f, 38.1f)
                curveToRelative(2.6f, 1.8f, 4.9f, 1.6f, 14.7f, -1f)
                lineToRelative(8.5f, -2.3f)
                lineToRelative(2.3f, 1.8f)
                curveToRelative(8.2f, 6.1f, 22.2f, 14f, 26.9f, 15.2f)
                curveToRelative(1.4f, 0.3f, 1.6f, 0.9f, 4f, 9.8f)
                curveToRelative(2.4f, 8.9f, 2.7f, 9.6f, 4.7f, 11.5f)
                curveToRelative(1.8f, 1.8f, 2.8f, 2.1f, 7f, 2.9f)
                curveToRelative(14.9f, 2.7f, 29.7f, 2.7f, 44.5f, 0f)
                curveToRelative(4.3f, -0.8f, 5.2f, -1.1f, 7f, -2.9f)
                curveToRelative(1.9f, -1.8f, 2.3f, -2.6f, 4.6f, -11.5f)
                curveToRelative(1.4f, -5.2f, 2.9f, -9.5f, 3.1f, -9.5f)
                curveToRelative(1.1f, 0f, 10.6f, -4.5f, 15.4f, -7.4f)
                curveToRelative(2.8f, -1.7f, 7.2f, -4.5f, 9.6f, -6.3f)
                curveToRelative(2.5f, -1.9f, 4.8f, -3.4f, 5.2f, -3.4f)
                curveToRelative(0.3f, 0f, 4.2f, 1f, 8.6f, 2.2f)
                curveToRelative(9.3f, 2.5f, 11.7f, 2.7f, 14.4f, 0.9f)
                curveToRelative(4.2f, -2.9f, 13.8f, -16f, 19.4f, -26.8f)
                curveToRelative(1.7f, -3.2f, 4.2f, -8.7f, 5.6f, -12.3f)
                curveToRelative(2.6f, -6.8f, 3.2f, -10.1f, 1.9f, -12.6f)
                curveToRelative(-0.4f, -0.7f, -3.6f, -4.3f, -7.3f, -8f)
                lineToRelative(-6.6f, -6.7f)
                lineToRelative(0.6f, -5.6f)
                curveToRelative(0.8f, -7.1f, 0.8f, -17.1f, 0f, -24.2f)
                lineToRelative(-0.6f, -5.6f)
                lineToRelative(6.6f, -6.7f)
                curveToRelative(3.7f, -3.7f, 6.9f, -7.3f, 7.3f, -8f)
                curveToRelative(1.7f, -3.4f, -0.1f, -9.7f, -6.3f, -22.5f)
                curveToRelative(-5.6f, -11.4f, -15.9f, -26.1f, -20.6f, -29.2f)
                curveToRelative(-2.6f, -1.8f, -5.1f, -1.6f, -14.4f, 0.9f)
                curveToRelative(-4.4f, 1.2f, -8.3f, 2.2f, -8.6f, 2.2f)
                reflectiveCurveToRelative(-2.9f, -1.6f, -5.5f, -3.5f)
                curveToRelative(-6.3f, -4.7f, -12.6f, -8.3f, -19.2f, -11.3f)
                curveToRelative(-3f, -1.3f, -5.7f, -2.6f, -5.9f, -2.8f)
                curveToRelative(-0.3f, -0.2f, -1.6f, -4.5f, -2.9f, -9.4f)
                curveToRelative(-2.3f, -8.4f, -2.5f, -9.2f, -4.5f, -11f)
                curveToRelative(-1.8f, -1.8f, -2.7f, -2.1f, -7f, -2.9f)
                curveTo(140.2f, 4.3f, 126.8f, 3.6f, 117.3f, 4.5f)
                close()
                moveTo(139.3f, 21.8f)
                curveToRelative(2.8f, 0.3f, 5.2f, 0.8f, 5.5f, 1f)
                curveToRelative(0.3f, 0.2f, 1.4f, 3.9f, 2.6f, 8.1f)
                curveToRelative(1.2f, 4.3f, 2.4f, 8.2f, 2.6f, 8.8f)
                curveToRelative(1.2f, 2.1f, 3.3f, 3.5f, 8.6f, 5.5f)
                curveToRelative(9.4f, 3.5f, 18.4f, 8.8f, 26.6f, 15.6f)
                curveToRelative(2.3f, 1.9f, 5f, 3.6f, 6.1f, 4f)
                curveToRelative(2.1f, 0.6f, 2.9f, 0.4f, 13.3f, -2.5f)
                curveToRelative(2.6f, -0.8f, 5.2f, -1.4f, 5.6f, -1.4f)
                curveToRelative(1.2f, 0f, 8.9f, 10.6f, 11.6f, 16f)
                curveToRelative(1.3f, 2.6f, 3.2f, 6.7f, 4.2f, 9f)
                lineToRelative(1.7f, 4.4f)
                lineToRelative(-6.6f, 6.7f)
                curveToRelative(-7.7f, 7.8f, -7.8f, 8.1f, -6.3f, 15.5f)
                curveToRelative(1.4f, 7f, 1.4f, 24.4f, 0f, 31.4f)
                curveToRelative(-1.5f, 7.4f, -1.4f, 7.7f, 6.3f, 15.5f)
                lineToRelative(6.6f, 6.7f)
                lineToRelative(-2.5f, 5.9f)
                curveToRelative(-1.4f, 3.3f, -3.5f, 7.7f, -4.7f, 9.7f)
                curveToRelative(-2.5f, 4.3f, -9.5f, 13.7f, -10.1f, 13.7f)
                curveToRelative(-0.3f, 0f, -4.1f, -1f, -8.5f, -2.2f)
                curveToRelative(-5.7f, -1.6f, -8.6f, -2.1f, -10.1f, -1.9f)
                curveToRelative(-1.3f, 0.2f, -3.4f, 1.5f, -6.3f, 4f)
                curveToRelative(-8.9f, 7.3f, -18.5f, 12.9f, -28.3f, 16.4f)
                curveToRelative(-4.4f, 1.5f, -6.7f, 3.3f, -7.7f, 5.7f)
                curveToRelative(-0.3f, 0.8f, -1.4f, 4.6f, -2.5f, 8.5f)
                curveToRelative(-1.1f, 3.9f, -2f, 7.2f, -2.2f, 7.3f)
                curveToRelative(-0.7f, 0.7f, -11.2f, 1.8f, -16.9f, 1.8f)
                curveToRelative(-5.6f, 0f, -16.2f, -1.2f, -16.8f, -1.8f)
                curveToRelative(-0.1f, -0.1f, -1.2f, -3.7f, -2.4f, -7.9f)
                curveToRelative(-1.2f, -4.3f, -2.4f, -8.2f, -2.7f, -8.8f)
                curveToRelative(-1.1f, -2f, -3.2f, -3.5f, -7.5f, -5.1f)
                curveToRelative(-11.5f, -4.2f, -20.8f, -9.7f, -29f, -17f)
                curveToRelative(-3.9f, -3.5f, -5.7f, -3.7f, -12.3f, -2f)
                curveToRelative(-3f, 0.8f, -6.7f, 1.8f, -8.2f, 2.2f)
                curveToRelative(-1.5f, 0.4f, -3f, 0.8f, -3.4f, 0.8f)
                curveToRelative(-0.8f, 0f, -7.4f, -8.8f, -10.2f, -13.7f)
                curveToRelative(-1.2f, -2f, -3.3f, -6.4f, -4.7f, -9.7f)
                lineToRelative(-2.5f, -5.9f)
                lineToRelative(6.6f, -6.7f)
                curveToRelative(7.5f, -7.7f, 7.8f, -8.2f, 6.4f, -14.6f)
                curveToRelative(-0.4f, -2.3f, -1f, -8.5f, -1.2f, -14f)
                curveToRelative(-0.2f, -8.5f, -0.1f, -10.9f, 0.9f, -16.8f)
                curveToRelative(0.9f, -5.2f, 1f, -7.3f, 0.6f, -8.8f)
                curveToRelative(-0.4f, -1.3f, -2.5f, -3.9f, -6.9f, -8.3f)
                lineToRelative(-6.3f, -6.3f)
                lineToRelative(1.7f, -4.4f)
                curveToRelative(1f, -2.4f, 2.9f, -6.4f, 4.2f, -9f)
                curveToRelative(2.7f, -5.3f, 10.5f, -16f, 11.6f, -16f)
                curveToRelative(0.4f, 0f, 4f, 0.9f, 7.9f, 1.9f)
                curveToRelative(10.7f, 2.9f, 11.4f, 2.8f, 17.7f, -2.5f)
                curveTo(78.8f, 54f, 88f, 48.6f, 97.5f, 45.1f)
                curveToRelative(5.3f, -2f, 7.5f, -3.3f, 8.6f, -5.5f)
                curveToRelative(0.3f, -0.6f, 1.5f, -4.5f, 2.6f, -8.7f)
                curveToRelative(1.2f, -4.2f, 2.3f, -7.9f, 2.5f, -8f)
                curveTo(112.7f, 21.4f, 130.8f, 20.7f, 139.3f, 21.8f)
                close()
            }
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(117.4f, 68.8f)
                curveTo(94.1f, 73.2f, 76f, 90f, 69.8f, 113f)
                curveToRelative(-1.3f, 4.8f, -1.5f, 6.3f, -1.5f, 15f)
                curveToRelative(0f, 8.6f, 0.2f, 10.2f, 1.5f, 15f)
                curveToRelative(6.9f, 25.9f, 28.9f, 43.7f, 55.5f, 44.9f)
                curveToRelative(19.8f, 0.8f, 37.8f, -7.3f, 49.9f, -22.6f)
                curveToRelative(4.5f, -5.7f, 9.1f, -14.9f, 11.1f, -22.1f)
                curveToRelative(1.3f, -5f, 1.5f, -6.4f, 1.5f, -15.1f)
                curveToRelative(0f, -8.7f, -0.2f, -10.2f, -1.5f, -15.1f)
                curveToRelative(-5.7f, -21.1f, -22.2f, -37.6f, -43.2f, -43.1f)
                curveTo(136.2f, 68f, 124.1f, 67.5f, 117.4f, 68.8f)
                close()
                moveTo(141.9f, 87.1f)
                curveToRelative(23.8f, 8.3f, 35.6f, 34.5f, 25.9f, 57.7f)
                curveToRelative(-5.5f, 13.1f, -18.6f, 23.4f, -32.9f, 25.9f)
                curveToRelative(-4.3f, 0.7f, -13.1f, 0.3f, -17.5f, -0.8f)
                curveToRelative(-9f, -2.3f, -18.8f, -9f, -24.3f, -16.5f)
                curveToRelative(-17.9f, -24.4f, -5.3f, -59.3f, 24.2f, -67.3f)
                curveToRelative(3.1f, -0.9f, 5.3f, -1f, 11.8f, -0.9f)
                curveTo(136.4f, 85.4f, 137.6f, 85.6f, 141.9f, 87.1f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberHelp(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "help",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(20.125f, 29.625f)
                quadToRelative(0.667f, 0f, 1.167f, -0.479f)
                reflectiveQuadToRelative(0.5f, -1.188f)
                quadToRelative(0f, -0.708f, -0.48f, -1.187f)
                quadToRelative(-0.479f, -0.479f, -1.187f, -0.479f)
                quadToRelative(-0.708f, 0f, -1.187f, 0.479f)
                quadToRelative(-0.48f, 0.479f, -0.48f, 1.187f)
                quadToRelative(0f, 0.667f, 0.48f, 1.167f)
                quadToRelative(0.479f, 0.5f, 1.187f, 0.5f)
                close()
                moveToRelative(0f, -16.917f)
                quadToRelative(1.333f, 0f, 2.167f, 0.73f)
                quadToRelative(0.833f, 0.729f, 0.833f, 1.854f)
                quadToRelative(0f, 0.791f, -0.458f, 1.562f)
                quadToRelative(-0.459f, 0.771f, -1.5f, 1.688f)
                quadToRelative(-1f, 0.875f, -1.729f, 1.896f)
                quadToRelative(-0.73f, 1.02f, -0.688f, 2.062f)
                quadToRelative(0f, 0.458f, 0.354f, 0.75f)
                reflectiveQuadToRelative(0.854f, 0.292f)
                quadToRelative(0.5f, 0f, 0.854f, -0.334f)
                quadToRelative(0.355f, -0.333f, 0.48f, -0.875f)
                quadToRelative(0.125f, -0.75f, 0.541f, -1.375f)
                quadToRelative(0.417f, -0.625f, 1.375f, -1.458f)
                quadToRelative(1.209f, -1.042f, 1.75f, -2.062f)
                quadToRelative(0.542f, -1.021f, 0.542f, -2.271f)
                quadToRelative(0f, -2.167f, -1.438f, -3.479f)
                quadToRelative(-1.437f, -1.313f, -3.812f, -1.313f)
                quadToRelative(-1.583f, 0f, -2.896f, 0.646f)
                quadToRelative(-1.312f, 0.646f, -2.187f, 1.854f)
                quadToRelative(-0.292f, 0.458f, -0.229f, 0.938f)
                quadToRelative(0.062f, 0.479f, 0.437f, 0.729f)
                quadToRelative(0.458f, 0.333f, 1f, 0.208f)
                quadToRelative(0.542f, -0.125f, 0.875f, -0.625f)
                quadToRelative(0.5f, -0.708f, 1.229f, -1.062f)
                quadToRelative(0.729f, -0.355f, 1.646f, -0.355f)
                close()
                moveTo(20f, 36.375f)
                quadToRelative(-3.417f, 0f, -6.417f, -1.25f)
                reflectiveQuadToRelative(-5.208f, -3.458f)
                quadToRelative(-2.208f, -2.209f, -3.479f, -5.209f)
                quadToRelative(-1.271f, -3f, -1.271f, -6.458f)
                reflectiveQuadToRelative(1.271f, -6.437f)
                quadToRelative(1.271f, -2.98f, 3.479f, -5.188f)
                quadToRelative(2.208f, -2.208f, 5.208f, -3.479f)
                reflectiveQuadTo(20f, 3.625f)
                quadToRelative(3.417f, 0f, 6.396f, 1.271f)
                reflectiveQuadToRelative(5.208f, 3.479f)
                quadToRelative(2.229f, 2.208f, 3.5f, 5.188f)
                quadToRelative(1.271f, 2.979f, 1.271f, 6.437f)
                reflectiveQuadToRelative(-1.271f, 6.458f)
                quadToRelative(-1.271f, 3f, -3.5f, 5.209f)
                quadToRelative(-2.229f, 2.208f, -5.208f, 3.458f)
                reflectiveQuadTo(20f, 36.375f)
                close()
                moveToRelative(0f, -16.667f)
                close()
                moveToRelative(0f, 14.042f)
                quadToRelative(5.708f, 0f, 9.729f, -4.042f)
                quadTo(33.75f, 25.667f, 33.75f, 20f)
                reflectiveQuadToRelative(-4.021f, -9.708f)
                quadTo(25.708f, 6.25f, 20f, 6.25f)
                quadToRelative(-5.75f, 0f, -9.75f, 4.042f)
                quadToRelative(-4f, 4.041f, -4f, 9.708f)
                reflectiveQuadToRelative(4f, 9.708f)
                quadToRelative(4f, 4.042f, 9.75f, 4.042f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberRecentViewed(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "RecentViewed",
            defaultWidth = 256.dp,
            defaultHeight = 256.dp,
            viewportWidth = 256f,
            viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(128.2f, 21.7f)
                curveToRelative(-10.3f, 1.1f, -21.9f, 4.2f, -31.5f, 8.4f)
                curveToRelative(-29.9f, 12.9f, -52.8f, 39.5f, -60.9f, 70.7f)
                curveToRelative(-1.6f, 6f, -2.9f, 13f, -2.9f, 15.4f)
                curveToRelative(0f, 1.6f, -0.1f, 1.6f, -8.1f, -6.4f)
                lineToRelative(-8.1f, -8.1f)
                lineToRelative(-3.4f, 3.4f)
                lineToRelative(-3.4f, 3.4f)
                lineToRelative(13.4f, 13.7f)
                curveToRelative(7.4f, 7.5f, 13.6f, 13.7f, 13.8f, 13.7f)
                curveToRelative(0.2f, 0f, 6.4f, -6.2f, 13.8f, -13.7f)
                lineToRelative(13.4f, -13.7f)
                lineToRelative(-3.4f, -3.4f)
                lineToRelative(-3.4f, -3.4f)
                lineToRelative(-7.5f, 7.5f)
                lineToRelative(-7.6f, 7.6f)
                lineToRelative(0.4f, -2.8f)
                curveToRelative(2.3f, -16.6f, 10.4f, -34.7f, 21.6f, -48.1f)
                curveToRelative(6.3f, -7.6f, 15f, -15.1f, 23.8f, -20.5f)
                curveToRelative(22f, -13.6f, 49.5f, -17.7f, 75f, -11.3f)
                curveToRelative(38.1f, 9.6f, 66.7f, 41.7f, 72.2f, 80.8f)
                curveToRelative(1f, 7f, 1f, 19.5f, 0f, 26.5f)
                curveToRelative(-4.5f, 32.2f, -24.6f, 59.8f, -53.7f, 73.9f)
                curveToRelative(-14.2f, 6.9f, -26.8f, 9.8f, -42.8f, 9.8f)
                curveToRelative(-18.5f, 0f, -35.4f, -4.7f, -50.7f, -14.2f)
                curveToRelative(-12.3f, -7.6f, -22.5f, -17.5f, -30.5f, -29.5f)
                lineToRelative(-3.2f, -4.8f)
                horizontalLineToRelative(-5.4f)
                horizontalLineToRelative(-5.4f)
                lineToRelative(1f, 2f)
                curveToRelative(3.8f, 7.4f, 10.4f, 16.4f, 17.4f, 23.8f)
                curveToRelative(16.6f, 17.2f, 38.4f, 28.3f, 63f, 31.8f)
                curveToRelative(6.4f, 0.9f, 22.5f, 0.8f, 29.2f, -0.2f)
                curveToRelative(35.2f, -5.4f, 65.2f, -27.2f, 80.5f, -58.5f)
                curveToRelative(5.2f, -10.6f, 7.9f, -18.9f, 9.9f, -30.7f)
                curveToRelative(1.4f, -8f, 1.5f, -23.7f, 0.2f, -31.8f)
                curveToRelative(-4.8f, -30.6f, -21.3f, -56.8f, -46.8f, -73.9f)
                curveToRelative(-12.6f, -8.4f, -28f, -14.3f, -43.3f, -16.6f)
                curveTo(148.9f, 21.4f, 134f, 21f, 128.2f, 21.7f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(134.4f, 60.7f)
                curveToRelative(-0.1f, 0.3f, -0.2f, 16.4f, -0.1f, 35.7f)
                lineToRelative(0.1f, 35.1f)
                lineToRelative(25.2f, 14.8f)
                curveToRelative(13.9f, 8.2f, 25.3f, 14.8f, 25.5f, 14.7f)
                curveToRelative(0.8f, -0.4f, 4.8f, -7.8f, 4.4f, -8.2f)
                curveToRelative(-0.2f, -0.2f, -10.5f, -6.4f, -22.8f, -13.7f)
                lineToRelative(-22.3f, -13.3f)
                lineToRelative(-0.1f, -32.9f)
                lineToRelative(-0.1f, -32.8f)
                horizontalLineToRelative(-4.8f)
                curveTo(136f, 60.1f, 134.5f, 60.3f, 134.4f, 60.7f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberProfile(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Customer595b40b65ba036ed117d4662",
            defaultWidth = 26.dp,
            defaultHeight = 26.dp,
            viewportWidth = 26f,
            viewportHeight = 26f
        ).apply {
            path(
                fill = SolidColor(color),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(13f, 0f)
                curveTo(9.7f, 0f, 7f, 2.1f, 7f, 6f)
                curveTo(7f, 8.6079f, 8.2133f, 11.3115f, 10f, 12.8125f)
                lineTo(10f, 14.1875f)
                curveTo(10f, 14.7875f, 9.5938f, 15.3063f, 9.0938f, 15.4063f)
                curveTo(5.1937f, 16.6062f, 2f, 19.1875f, 2f, 20.6875f)
                lineTo(2f, 22.5f)
                curveTo(2f, 24.4f, 6.9f, 26f, 13f, 26f)
                curveTo(19.1f, 26f, 24f, 24.4f, 24f, 22.5f)
                lineTo(24f, 20.6875f)
                curveTo(24f, 19.2875f, 20.9063f, 16.6062f, 16.9063f, 15.4063f)
                curveTo(16.4063f, 15.3063f, 16f, 14.6875f, 16f, 14.1875f)
                lineTo(16f, 12.8125f)
                curveTo(17.7867f, 11.3115f, 19f, 8.6079f, 19f, 6f)
                curveTo(19f, 2.1f, 16.3f, 0f, 13f, 0f)
                close()
            }
        }.build()
    }
}

