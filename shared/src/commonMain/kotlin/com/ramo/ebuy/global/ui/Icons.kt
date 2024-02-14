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

@Composable
fun rememberEbuy(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Ebuy",
            defaultWidth = 144.dp,
            defaultHeight = 144.dp,
            viewportWidth = 144f,
            viewportHeight = 144f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFC107)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(73.96f, 77.52f)
                lineTo(73.96f, 57f)
                lineTo(81.92f, 57f)
                lineTo(81.92f, 77.52f)
                curveTo(82.02f, 83.44f, 84.68f, 86.46f, 89.87f, 86.57f)
                curveTo(94.85f, 86.57f, 97.34f, 83.5f, 97.34f, 77.35f)
                lineTo(97.34f, 57f)
                lineTo(105.44f, 57f)
                lineTo(105.44f, 77.19f)
                curveTo(105.44f, 87.85f, 100.08f, 93.18f, 89.38f, 93.18f)
                curveTo(79.22f, 93.19f, 74.07f, 87.96f, 73.96f, 77.52f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF44336)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(18f, 57f)
                curveTo(-0.01f, 57f, -0.09f, 70.59f, 0.01f, 74.11f)
                curveTo(0.01f, 74.11f, -0.87f, 90f, 18.18f, 90f)
                curveTo(34.55f, 90f, 35.36f, 80.03f, 35.36f, 80.03f)
                lineTo(27.83f, 80.04f)
                curveTo(27.83f, 80.04f, 26.36f, 85.53f, 18.22f, 85.38f)
                curveTo(7.74f, 85.2f, 7.33f, 75f, 7.33f, 75f)
                lineTo(36f, 75f)
                curveTo(36f, 75f, 37.93f, 57f, 18f, 57f)
                close()
                moveTo(7.57f, 70.54f)
                curveTo(7.57f, 70.54f, 8.09f, 61.64f, 18.44f, 61.64f)
                curveTo(28.76f, 61.64f, 28.76f, 70.54f, 28.76f, 70.54f)
                lineTo(7.57f, 70.54f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF1976D2)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(56.47f, 57f)
                curveTo(47.3f, 56.95f, 43.35f, 62.16f, 43.35f, 62.16f)
                lineTo(43.35f, 45f)
                lineTo(36f, 45f)
                lineTo(36f, 90f)
                lineTo(42.95f, 90f)
                lineTo(43.26f, 84.8f)
                curveTo(43.26f, 84.8f, 46.59f, 90f, 56.33f, 90f)
                curveTo(66.07f, 90f, 73.76f, 84.31f, 73.96f, 73.75f)
                curveTo(74.16f, 63.19f, 65.65f, 57.05f, 56.47f, 57f)
                close()
                moveTo(54.79f, 85.29f)
                curveTo(43.2f, 85.43f, 43.39f, 73.63f, 43.39f, 73.63f)
                curveTo(43.39f, 73.63f, 42.97f, 62.01f, 54.77f, 61.72f)
                curveTo(66.57f, 61.43f, 66.4f, 73.87f, 66.4f, 73.87f)
                curveTo(66.4f, 73.87f, 66.38f, 85.15f, 54.79f, 85.29f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF8BC34A)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(103.31f, 57f)
                lineTo(111.73f, 57f)
                lineTo(124.05f, 81.56f)
                lineTo(136.39f, 57f)
                lineTo(144f, 57f)
                lineTo(121.72f, 102f)
                lineTo(113.58f, 102f)
                lineTo(120.03f, 88.61f)
                lineTo(103.31f, 57f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberFacebook(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Facebook",
            defaultWidth = 150.dp,
            defaultHeight = 150.dp,
            viewportWidth = 150f,
            viewportHeight = 150f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF039BE5)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(111f, 45f)
                lineTo(111f, 57f)
                lineTo(105f, 57f)
                curveTo(98.58f, 57f, 96f, 58.5f, 96f, 63f)
                lineTo(96f, 72f)
                lineTo(111f, 72f)
                lineTo(108f, 87f)
                lineTo(96f, 87f)
                lineTo(96f, 132f)
                lineTo(81f, 132f)
                lineTo(81f, 87f)
                lineTo(69f, 87f)
                lineTo(69f, 72f)
                lineTo(81f, 72f)
                lineTo(81f, 63f)
                curveTo(81f, 51f, 87f, 42f, 99f, 42f)
                curveTo(107.7f, 42f, 111f, 45f, 111f, 45f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(138f, 27f)
                lineTo(138f, 123f)
                curveTo(138f, 131.28f, 131.28f, 138f, 123f, 138f)
                lineTo(27f, 138f)
                curveTo(18.72f, 138f, 12f, 131.28f, 12f, 123f)
                lineTo(12f, 27f)
                curveTo(12f, 18.72f, 18.72f, 12f, 27f, 12f)
                lineTo(123f, 12f)
                curveTo(131.28f, 12f, 138f, 18.72f, 138f, 27f)
                close()
                moveTo(111f, 57f)
                lineTo(111f, 45f)
                curveTo(111f, 45f, 107.7f, 42f, 99f, 42f)
                curveTo(87f, 42f, 81f, 51f, 81f, 63f)
                lineTo(81f, 72f)
                lineTo(69f, 72f)
                lineTo(69f, 87f)
                lineTo(81f, 87f)
                lineTo(81f, 132f)
                lineTo(96f, 132f)
                lineTo(96f, 87f)
                lineTo(108f, 87f)
                lineTo(111f, 72f)
                lineTo(96f, 72f)
                lineTo(96f, 63f)
                curveTo(96f, 58.5f, 98.58f, 57f, 105f, 57f)
                lineTo(111f, 57f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberGoogle(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Google",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 48f,
            viewportHeight = 48f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFC107)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(43.611f, 20.083f)
                lineTo(42f, 20.083f)
                lineTo(42f, 20f)
                lineTo(24f, 20f)
                lineTo(24f, 28f)
                lineTo(35.303f, 28f)
                curveTo(33.654f, 32.657f, 29.223f, 36f, 24f, 36f)
                curveTo(17.373f, 36f, 12f, 30.627f, 12f, 24f)
                curveTo(12f, 17.373f, 17.373f, 12f, 24f, 12f)
                curveTo(27.059f, 12f, 29.842f, 13.154f, 31.961f, 15.039f)
                lineTo(37.618f, 9.382f)
                curveTo(34.046f, 6.053f, 29.268f, 4f, 24f, 4f)
                curveTo(12.955f, 4f, 4f, 12.955f, 4f, 24f)
                curveTo(4f, 35.045f, 12.955f, 44f, 24f, 44f)
                curveTo(35.045f, 44f, 44f, 35.045f, 44f, 24f)
                curveTo(44f, 22.659f, 43.862f, 21.35f, 43.611f, 20.083f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFF3D00)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(6.306f, 14.691f)
                lineTo(12.877f, 19.51f)
                curveTo(14.655f, 15.108f, 18.961f, 12f, 24f, 12f)
                curveTo(27.059f, 12f, 29.842f, 13.154f, 31.961f, 15.039f)
                lineTo(37.618f, 9.382f)
                curveTo(34.046f, 6.053f, 29.268f, 4f, 24f, 4f)
                curveTo(16.318f, 4f, 9.656f, 8.337f, 6.306f, 14.691f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF4CAF50)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(24f, 44f)
                curveTo(29.166f, 44f, 33.86f, 42.023f, 37.409f, 38.808f)
                lineTo(31.219f, 33.57f)
                curveTo(29.211f, 35.091f, 26.715f, 36f, 24f, 36f)
                curveTo(18.798f, 36f, 14.381f, 32.683f, 12.717f, 28.054f)
                lineTo(6.195f, 33.079f)
                curveTo(9.505f, 39.556f, 16.227f, 44f, 24f, 44f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF1976D2)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(43.611f, 20.083f)
                lineTo(42f, 20.083f)
                lineTo(42f, 20f)
                lineTo(24f, 20f)
                lineTo(24f, 28f)
                lineTo(35.303f, 28f)
                curveTo(34.511f, 30.237f, 33.072f, 32.166f, 31.216f, 33.571f)
                curveTo(31.217f, 33.57f, 31.218f, 33.57f, 31.219f, 33.569f)
                lineTo(37.409f, 38.807f)
                curveTo(36.971f, 39.205f, 44f, 34f, 44f, 24f)
                curveTo(44f, 22.659f, 43.862f, 21.35f, 43.611f, 20.083f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberShoppingCart(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "shopping_cart",
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
                moveTo(11.958f, 36.375f)
                quadToRelative(-1.25f, 0f, -2.125f, -0.896f)
                reflectiveQuadToRelative(-0.875f, -2.146f)
                quadToRelative(0f, -1.25f, 0.875f, -2.145f)
                quadToRelative(0.875f, -0.896f, 2.125f, -0.896f)
                reflectiveQuadToRelative(2.146f, 0.896f)
                quadToRelative(0.896f, 0.895f, 0.896f, 2.145f)
                reflectiveQuadToRelative(-0.896f, 2.146f)
                quadToRelative(-0.896f, 0.896f, -2.146f, 0.896f)
                close()
                moveToRelative(16.417f, 0f)
                quadToRelative(-1.25f, 0f, -2.125f, -0.896f)
                reflectiveQuadToRelative(-0.875f, -2.146f)
                quadToRelative(0f, -1.25f, 0.875f, -2.145f)
                quadToRelative(0.875f, -0.896f, 2.125f, -0.896f)
                reflectiveQuadToRelative(2.146f, 0.896f)
                quadToRelative(0.896f, 0.895f, 0.896f, 2.145f)
                reflectiveQuadToRelative(-0.896f, 2.146f)
                quadToRelative(-0.896f, 0.896f, -2.146f, 0.896f)
                close()
                moveTo(10f, 9.458f)
                lineToRelative(4.375f, 9.084f)
                horizontalLineToRelative(11.75f)
                lineToRelative(5f, -9.084f)
                close()
                moveToRelative(1.708f, 18.417f)
                quadToRelative(-1.791f, 0f, -2.583f, -1.271f)
                quadToRelative(-0.792f, -1.271f, 0f, -2.729f)
                lineToRelative(2.5f, -4.625f)
                lineTo(5.458f, 6.208f)
                horizontalLineTo(3.542f)
                quadToRelative(-0.542f, 0f, -0.917f, -0.395f)
                quadToRelative(-0.375f, -0.396f, -0.375f, -0.938f)
                quadToRelative(0f, -0.542f, 0.396f, -0.937f)
                quadToRelative(0.396f, -0.396f, 0.937f, -0.396f)
                horizontalLineToRelative(2.75f)
                quadToRelative(0.375f, 0f, 0.709f, 0.208f)
                quadToRelative(0.333f, 0.208f, 0.458f, 0.542f)
                lineToRelative(1.208f, 2.5f)
                horizontalLineToRelative(24.167f)
                quadToRelative(1.292f, 0f, 1.646f, 0.791f)
                quadToRelative(0.354f, 0.792f, -0.188f, 1.792f)
                lineToRelative(-5.625f, 10.083f)
                quadToRelative(-0.416f, 0.75f, -1.146f, 1.25f)
                quadToRelative(-0.729f, 0.5f, -1.604f, 0.5f)
                horizontalLineTo(13.542f)
                lineToRelative(-2.167f, 4.042f)
                horizontalLineToRelative(18.792f)
                quadToRelative(0.5f, 0f, 0.875f, 0.396f)
                reflectiveQuadToRelative(0.375f, 0.937f)
                quadToRelative(0f, 0.542f, -0.396f, 0.917f)
                reflectiveQuadToRelative(-0.896f, 0.375f)
                close()
                moveToRelative(2.667f, -9.333f)
                horizontalLineToRelative(11.75f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberShare(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "share",
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
                moveTo(30.125f, 36.417f)
                quadToRelative(-1.958f, 0f, -3.354f, -1.375f)
                quadToRelative(-1.396f, -1.375f, -1.396f, -3.334f)
                quadToRelative(0f, -0.291f, 0.063f, -0.666f)
                quadToRelative(0.062f, -0.375f, 0.187f, -0.667f)
                lineToRelative(-12.333f, -7.167f)
                quadToRelative(-0.625f, 0.709f, -1.521f, 1.104f)
                quadToRelative(-0.896f, 0.396f, -1.813f, 0.396f)
                quadToRelative(-2f, 0f, -3.375f, -1.375f)
                reflectiveQuadTo(5.208f, 20f)
                quadToRelative(0f, -1.958f, 1.396f, -3.333f)
                quadTo(8f, 15.292f, 9.958f, 15.292f)
                quadToRelative(0.917f, 0f, 1.792f, 0.354f)
                reflectiveQuadToRelative(1.542f, 1.021f)
                lineToRelative(12.333f, -7.084f)
                quadToRelative(-0.125f, -0.291f, -0.187f, -0.645f)
                quadToRelative(-0.063f, -0.355f, -0.063f, -0.646f)
                quadToRelative(0f, -1.959f, 1.396f, -3.354f)
                quadToRelative(1.396f, -1.396f, 3.354f, -1.396f)
                quadToRelative(1.958f, 0f, 3.333f, 1.375f)
                quadToRelative(1.375f, 1.375f, 1.375f, 3.333f)
                quadToRelative(0f, 2f, -1.375f, 3.375f)
                reflectiveQuadTo(30.125f, 13f)
                quadToRelative(-0.958f, 0f, -1.833f, -0.312f)
                quadToRelative(-0.875f, -0.313f, -1.5f, -1.021f)
                lineToRelative(-12.334f, 6.916f)
                quadToRelative(0.084f, 0.292f, 0.146f, 0.709f)
                quadToRelative(0.063f, 0.416f, 0.063f, 0.708f)
                reflectiveQuadToRelative(-0.063f, 0.625f)
                quadToRelative(-0.062f, 0.333f, -0.146f, 0.625f)
                lineToRelative(12.334f, 7.042f)
                quadToRelative(0.625f, -0.625f, 1.458f, -0.98f)
                quadToRelative(0.833f, -0.354f, 1.875f, -0.354f)
                quadToRelative(1.958f, 0f, 3.333f, 1.396f)
                quadToRelative(1.375f, 1.396f, 1.375f, 3.354f)
                quadToRelative(0f, 1.959f, -1.375f, 3.334f)
                reflectiveQuadToRelative(-3.333f, 1.375f)
                close()
                moveToRelative(0f, -26.042f)
                quadToRelative(0.875f, 0f, 1.479f, -0.625f)
                quadToRelative(0.604f, -0.625f, 0.604f, -1.458f)
                quadToRelative(0f, -0.875f, -0.625f, -1.479f)
                quadToRelative(-0.625f, -0.605f, -1.458f, -0.605f)
                quadToRelative(-0.875f, 0f, -1.479f, 0.605f)
                quadToRelative(-0.604f, 0.604f, -0.604f, 1.479f)
                quadToRelative(0f, 0.875f, 0.604f, 1.479f)
                quadToRelative(0.604f, 0.604f, 1.479f, 0.604f)
                close()
                moveTo(9.958f, 22.083f)
                quadToRelative(0.875f, 0f, 1.48f, -0.604f)
                quadToRelative(0.604f, -0.604f, 0.604f, -1.479f)
                quadToRelative(0f, -0.875f, -0.625f, -1.479f)
                quadToRelative(-0.625f, -0.604f, -1.459f, -0.604f)
                quadToRelative(-0.875f, 0f, -1.479f, 0.604f)
                quadToRelative(-0.604f, 0.604f, -0.604f, 1.479f)
                quadToRelative(0f, 0.875f, 0.604f, 1.479f)
                quadToRelative(0.604f, 0.604f, 1.479f, 0.604f)
                close()
                moveToRelative(20.167f, 11.709f)
                quadToRelative(0.875f, 0f, 1.479f, -0.625f)
                quadToRelative(0.604f, -0.625f, 0.604f, -1.459f)
                quadToRelative(0f, -0.875f, -0.625f, -1.479f)
                quadToRelative(-0.625f, -0.604f, -1.458f, -0.604f)
                quadToRelative(-0.875f, 0f, -1.479f, 0.604f)
                quadToRelative(-0.604f, 0.604f, -0.604f, 1.479f)
                quadToRelative(0f, 0.875f, 0.604f, 1.48f)
                quadToRelative(0.604f, 0.604f, 1.479f, 0.604f)
                close()
                moveToRelative(0f, -25.5f)
                close()
                moveTo(9.958f, 20f)
                close()
                moveToRelative(20.167f, 11.708f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberMenu(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Menu",
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
                moveTo(121.2f, 10.9f)
                curveToRelative(-14.4f, 3.9f, -23.3f, 18.8f, -19.6f, 32.9f)
                curveToRelative(3.8f, 14.5f, 18.7f, 23.5f, 32.9f, 19.9f)
                curveToRelative(14.5f, -3.8f, 23.5f, -18.7f, 19.9f, -32.8f)
                curveTo(150.6f, 16.1f, 135.5f, 7f, 121.2f, 10.9f)
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
                moveTo(121.2f, 101.7f)
                curveToRelative(-14.4f, 3.9f, -23.3f, 18.8f, -19.6f, 32.9f)
                curveToRelative(3.8f, 14.5f, 18.7f, 23.5f, 32.9f, 19.9f)
                curveToRelative(14.5f, -3.8f, 23.5f, -18.7f, 19.9f, -32.8f)
                curveTo(150.6f, 106.9f, 135.5f, 97.8f, 121.2f, 101.7f)
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
                moveTo(121.2f, 192.5f)
                curveToRelative(-14.4f, 3.9f, -23.3f, 18.8f, -19.6f, 32.9f)
                curveToRelative(3.8f, 14.5f, 18.7f, 23.5f, 32.9f, 19.9f)
                curveToRelative(14.5f, -3.8f, 23.5f, -18.7f, 19.9f, -32.8f)
                curveTo(150.6f, 197.7f, 135.5f, 188.6f, 121.2f, 192.5f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberArrowBack(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "arrow_back",
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
                moveTo(18.542f, 32.208f)
                lineTo(7.25f, 20.917f)
                quadToRelative(-0.208f, -0.209f, -0.292f, -0.438f)
                quadToRelative(-0.083f, -0.229f, -0.083f, -0.479f)
                quadToRelative(0f, -0.25f, 0.083f, -0.479f)
                quadToRelative(0.084f, -0.229f, 0.292f, -0.438f)
                lineTo(18.583f, 7.75f)
                quadToRelative(0.375f, -0.333f, 0.896f, -0.333f)
                reflectiveQuadToRelative(0.938f, 0.375f)
                quadToRelative(0.375f, 0.416f, 0.375f, 0.937f)
                quadToRelative(0f, 0.521f, -0.375f, 0.938f)
                lineToRelative(-9.042f, 9f)
                horizontalLineToRelative(19.917f)
                quadToRelative(0.541f, 0f, 0.916f, 0.395f)
                quadToRelative(0.375f, 0.396f, 0.375f, 0.938f)
                quadToRelative(0f, 0.542f, -0.375f, 0.917f)
                reflectiveQuadToRelative(-0.916f, 0.375f)
                horizontalLineTo(11.375f)
                lineToRelative(9.083f, 9.083f)
                quadToRelative(0.334f, 0.375f, 0.334f, 0.896f)
                reflectiveQuadToRelative(-0.375f, 0.937f)
                quadToRelative(-0.417f, 0.375f, -0.938f, 0.375f)
                quadToRelative(-0.521f, 0f, -0.937f, -0.375f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberClose(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "close",
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
                moveTo(20f, 21.875f)
                lineToRelative(-8.5f, 8.5f)
                quadToRelative(-0.417f, 0.375f, -0.938f, 0.375f)
                quadToRelative(-0.52f, 0f, -0.937f, -0.375f)
                quadToRelative(-0.375f, -0.417f, -0.375f, -0.937f)
                quadToRelative(0f, -0.521f, 0.375f, -0.938f)
                lineToRelative(8.542f, -8.542f)
                lineToRelative(-8.542f, -8.5f)
                quadToRelative(-0.375f, -0.375f, -0.375f, -0.916f)
                quadToRelative(0f, -0.542f, 0.375f, -0.917f)
                quadToRelative(0.417f, -0.417f, 0.937f, -0.417f)
                quadToRelative(0.521f, 0f, 0.938f, 0.417f)
                lineToRelative(8.5f, 8.5f)
                lineToRelative(8.5f, -8.5f)
                quadToRelative(0.417f, -0.375f, 0.938f, -0.375f)
                quadToRelative(0.52f, 0f, 0.937f, 0.375f)
                quadToRelative(0.375f, 0.417f, 0.375f, 0.938f)
                quadToRelative(0f, 0.52f, -0.375f, 0.937f)
                lineTo(21.833f, 20f)
                lineToRelative(8.542f, 8.542f)
                quadToRelative(0.375f, 0.375f, 0.396f, 0.916f)
                quadToRelative(0.021f, 0.542f, -0.396f, 0.917f)
                quadToRelative(-0.375f, 0.375f, -0.917f, 0.375f)
                quadToRelative(-0.541f, 0f, -0.916f, -0.375f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberCorrect(color: Color = Color.Green): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Correct",
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
                moveTo(128f, 10f)
                curveTo(62.8f, 10f, 10f, 62.8f, 10f, 128f)
                curveToRelative(0f, 65.2f, 52.8f, 118f, 118f, 118f)
                curveToRelative(65.2f, 0f, 118f, -52.8f, 118f, -118f)
                curveTo(246f, 62.8f, 193.2f, 10f, 128f, 10f)
                lineTo(128f, 10f)
                lineTo(128f, 10f)
                close()
                moveTo(201.5f, 99f)
                lineToRelative(-82.6f, 79.6f)
                curveToRelative(-1.1f, 1.1f, -2.3f, 2f, -3.7f, 2.6f)
                curveToRelative(-5.2f, 3.7f, -12.4f, 3.2f, -17.1f, -1.4f)
                lineToRelative(-35.4f, -35.5f)
                curveToRelative(-5.2f, -5.2f, -5.2f, -13.6f, 0f, -18.8f)
                curveToRelative(5.2f, -5.2f, 13.6f, -5.2f, 18.8f, 0f)
                lineToRelative(26.6f, 26.6f)
                lineToRelative(74.6f, -72f)
                curveToRelative(5.2f, -5.2f, 13.6f, -5.2f, 18.8f, 0f)
                curveTo(206.7f, 85.4f, 206.7f, 93.9f, 201.5f, 99f)
                lineTo(201.5f, 99f)
                lineTo(201.5f, 99f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberWrong(color: Color = Color.Red): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Wrong",
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
                moveTo(128f, 9.9f)
                curveTo(62.8f, 9.9f, 10f, 62.8f, 10f, 128f)
                curveToRelative(0f, 65.2f, 52.8f, 118.1f, 118f, 118.1f)
                curveToRelative(65.2f, 0f, 118f, -52.9f, 118f, -118.1f)
                curveTo(246f, 62.8f, 193.2f, 9.9f, 128f, 9.9f)
                close()
                moveTo(181.2f, 154.9f)
                curveToRelative(7.2f, 7.2f, 7.8f, 18.3f, 1.4f, 24.6f)
                curveToRelative(-6.4f, 6.4f, -17.4f, 5.7f, -24.6f, -1.4f)
                lineToRelative(-27.8f, -27.8f)
                lineToRelative(-27.8f, 27.8f)
                curveToRelative(-7.2f, 7.2f, -18.3f, 7.8f, -24.6f, 1.4f)
                curveToRelative(-6.4f, -6.4f, -5.7f, -17.5f, 1.4f, -24.6f)
                lineToRelative(27.8f, -27.8f)
                lineTo(79.4f, 99.3f)
                curveToRelative(-7.2f, -7.2f, -7.8f, -18.3f, -1.4f, -24.7f)
                curveToRelative(6.4f, -6.4f, 17.4f, -5.7f, 24.6f, 1.5f)
                lineToRelative(27.8f, 27.8f)
                lineToRelative(27.8f, -27.8f)
                curveToRelative(7.2f, -7.2f, 18.3f, -7.9f, 24.6f, -1.5f)
                curveToRelative(6.4f, 6.4f, 5.7f, 17.5f, -1.4f, 24.7f)
                lineToRelative(-27.8f, 27.8f)
                lineTo(181.2f, 154.9f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberAdd(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Add",
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
                moveTo(118.9f, 10.1f)
                curveTo(102.2f, 11.8f, 89.7f, 15.2f, 76f, 22f)
                curveToRelative(-12f, 5.9f, -20.6f, 12f, -30.4f, 21.5f)
                curveTo(35.5f, 53.3f, 28.2f, 63.4f, 21.9f, 76f)
                curveToRelative(-5.8f, 11.9f, -9.4f, 23.6f, -11.4f, 37.4f)
                curveToRelative(-0.8f, 5.4f, -0.8f, 23.6f, 0f, 29.1f)
                curveToRelative(3.3f, 22.9f, 12.1f, 43.4f, 26.1f, 60.4f)
                curveToRelative(32.6f, 39.6f, 86.6f, 53.7f, 134.2f, 35.1f)
                curveToRelative(30.5f, -11.9f, 55.2f, -36.7f, 67.2f, -67.3f)
                curveToRelative(4.9f, -12.6f, 7.4f, -24.7f, 7.9f, -38.8f)
                curveToRelative(1.1f, -31.9f, -10.8f, -62.7f, -33.1f, -85.8f)
                curveToRelative(-10.2f, -10.5f, -20.1f, -17.7f, -33f, -24f)
                curveToRelative(-11.6f, -5.7f, -22.3f, -9.1f, -35.3f, -11.1f)
                curveTo(139.9f, 10.3f, 122.9f, 9.7f, 118.9f, 10.1f)
                close()
                moveTo(133f, 55.7f)
                curveToRelative(1f, 0.6f, 2.2f, 1.9f, 2.8f, 2.9f)
                lineToRelative(1.1f, 1.8f)
                lineToRelative(0.1f, 29.2f)
                lineToRelative(0.1f, 29.2f)
                lineToRelative(29.2f, 0.1f)
                lineToRelative(29.2f, 0.1f)
                lineToRelative(1.8f, 1.1f)
                curveToRelative(1f, 0.6f, 2.3f, 1.9f, 3f, 3f)
                curveToRelative(1f, 1.6f, 1.2f, 2.4f, 1.2f, 4.9f)
                curveToRelative(0f, 3.6f, -1.2f, 5.9f, -4.1f, 7.8f)
                lineToRelative(-1.9f, 1.2f)
                lineToRelative(-29.2f, 0.1f)
                lineToRelative(-29.2f, 0.1f)
                lineToRelative(-0.1f, 29.2f)
                lineToRelative(-0.1f, 29.3f)
                lineToRelative(-1.4f, 2f)
                curveToRelative(-3.7f, 5.3f, -11.5f, 5.3f, -15.2f, 0f)
                lineToRelative(-1.4f, -2f)
                lineToRelative(-0.1f, -29.3f)
                lineToRelative(-0.1f, -29.2f)
                lineToRelative(-29.2f, -0.1f)
                lineTo(60.2f, 137f)
                lineToRelative(-2f, -1.4f)
                curveToRelative(-2.7f, -1.9f, -3.9f, -4.3f, -3.9f, -7.8f)
                curveToRelative(0f, -3.4f, 1.2f, -5.7f, 4.1f, -7.5f)
                lineToRelative(1.9f, -1.2f)
                lineToRelative(29.2f, -0.1f)
                lineToRelative(29.2f, -0.1f)
                verticalLineTo(90.4f)
                curveToRelative(0f, -18.5f, 0.2f, -28.8f, 0.5f, -30f)
                curveToRelative(0.6f, -2.1f, 3.5f, -5.2f, 5.6f, -5.8f)
                curveTo(127.2f, 53.9f, 131f, 54.3f, 133f, 55.7f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberEdit(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "edit",
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
                moveTo(7.958f, 32.042f)
                horizontalLineToRelative(1.875f)
                lineTo(27f, 14.875f)
                lineTo(25.083f, 13f)
                lineTo(7.958f, 30.167f)
                close()
                moveTo(32.583f, 13f)
                lineToRelative(-5.625f, -5.583f)
                lineToRelative(1.875f, -1.875f)
                quadToRelative(0.75f, -0.75f, 1.875f, -0.75f)
                reflectiveQuadToRelative(1.875f, 0.791f)
                lineToRelative(1.875f, 1.875f)
                quadToRelative(0.75f, 0.75f, 0.75f, 1.855f)
                quadToRelative(0f, 1.104f, -0.75f, 1.854f)
                close()
                moveTo(6.625f, 34.667f)
                quadToRelative(-0.583f, 0f, -0.958f, -0.375f)
                reflectiveQuadToRelative(-0.375f, -0.917f)
                verticalLineToRelative(-3.792f)
                quadToRelative(0f, -0.25f, 0.104f, -0.479f)
                quadToRelative(0.104f, -0.229f, 0.312f, -0.437f)
                lineTo(25.125f, 9.25f)
                lineToRelative(5.625f, 5.625f)
                lineToRelative(-19.458f, 19.417f)
                quadToRelative(-0.167f, 0.208f, -0.417f, 0.291f)
                quadToRelative(-0.25f, 0.084f, -0.5f, 0.084f)
                close()
                moveToRelative(19.417f, -20.75f)
                lineTo(25.083f, 13f)
                lineTo(27f, 14.875f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberDeleteForever(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "delete_forever",
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
                moveTo(11.208f, 34.708f)
                quadToRelative(-1.041f, 0f, -1.833f, -0.77f)
                quadToRelative(-0.792f, -0.771f, -0.792f, -1.855f)
                verticalLineTo(9.25f)
                horizontalLineTo(8.25f)
                quadToRelative(-0.583f, 0f, -0.958f, -0.396f)
                reflectiveQuadToRelative(-0.375f, -0.937f)
                quadToRelative(0f, -0.542f, 0.375f, -0.917f)
                reflectiveQuadToRelative(0.958f, -0.375f)
                horizontalLineToRelative(6.458f)
                quadToRelative(0f, -0.583f, 0.375f, -0.958f)
                reflectiveQuadToRelative(0.959f, -0.375f)
                horizontalLineTo(24f)
                quadToRelative(0.583f, 0f, 0.938f, 0.375f)
                quadToRelative(0.354f, 0.375f, 0.354f, 0.958f)
                horizontalLineToRelative(6.5f)
                quadToRelative(0.541f, 0f, 0.937f, 0.375f)
                reflectiveQuadToRelative(0.396f, 0.917f)
                quadToRelative(0f, 0.583f, -0.396f, 0.958f)
                reflectiveQuadToRelative(-0.937f, 0.375f)
                horizontalLineToRelative(-0.334f)
                verticalLineToRelative(22.833f)
                quadToRelative(0f, 1.084f, -0.791f, 1.855f)
                quadToRelative(-0.792f, 0.77f, -1.875f, 0.77f)
                close()
                moveToRelative(0f, -25.458f)
                verticalLineToRelative(22.833f)
                horizontalLineToRelative(17.584f)
                verticalLineTo(9.25f)
                close()
                moveToRelative(0f, 0f)
                verticalLineToRelative(22.833f)
                verticalLineTo(9.25f)
                close()
                moveTo(20f, 22.625f)
                lineToRelative(3.708f, 3.75f)
                quadToRelative(0.459f, 0.417f, 1.042f, 0.417f)
                reflectiveQuadToRelative(1f, -0.417f)
                quadToRelative(0.417f, -0.417f, 0.438f, -1.021f)
                quadToRelative(0.02f, -0.604f, -0.438f, -0.979f)
                lineToRelative(-3.708f, -3.75f)
                lineToRelative(3.708f, -3.792f)
                quadToRelative(0.417f, -0.416f, 0.438f, -1f)
                quadToRelative(0.02f, -0.583f, -0.438f, -1f)
                quadToRelative(-0.417f, -0.416f, -1f, -0.416f)
                reflectiveQuadToRelative(-1.042f, 0.416f)
                lineToRelative(-3.666f, 3.75f)
                lineToRelative(-3.709f, -3.75f)
                quadToRelative(-0.375f, -0.416f, -0.979f, -0.416f)
                reflectiveQuadToRelative(-1.062f, 0.416f)
                quadToRelative(-0.417f, 0.417f, -0.417f, 1f)
                quadToRelative(0f, 0.584f, 0.417f, 1.042f)
                lineToRelative(3.75f, 3.75f)
                lineToRelative(-3.75f, 3.708f)
                quadToRelative(-0.417f, 0.459f, -0.417f, 1.021f)
                quadToRelative(0f, 0.563f, 0.417f, 1.021f)
                quadToRelative(0.458f, 0.417f, 1.041f, 0.417f)
                quadToRelative(0.584f, 0f, 1f, -0.417f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberArrowDropDown(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "arrow_drop_down",
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
                moveTo(19.083f, 23.958f)
                lineTo(14.125f, 19f)
                quadToRelative(-0.625f, -0.625f, -0.271f, -1.417f)
                quadToRelative(0.354f, -0.791f, 1.188f, -0.791f)
                horizontalLineToRelative(9.916f)
                quadToRelative(0.834f, 0f, 1.188f, 0.791f)
                quadToRelative(0.354f, 0.792f, -0.271f, 1.417f)
                lineToRelative(-4.958f, 4.958f)
                quadToRelative(-0.209f, 0.209f, -0.438f, 0.313f)
                quadToRelative(-0.229f, 0.104f, -0.479f, 0.104f)
                quadToRelative(-0.25f, 0f, -0.479f, -0.104f)
                quadToRelative(-0.229f, -0.104f, -0.438f, -0.313f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberWifiOff(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "wifi_off",
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
                moveTo(20f, 34.458f)
                quadToRelative(-1.542f, 0f, -2.646f, -1.104f)
                quadToRelative(-1.104f, -1.104f, -1.104f, -2.646f)
                quadToRelative(0f, -1.5f, 1.104f, -2.625f)
                reflectiveQuadTo(20f, 26.958f)
                quadToRelative(1.542f, 0f, 2.646f, 1.125f)
                quadToRelative(1.104f, 1.125f, 1.104f, 2.625f)
                quadToRelative(0f, 1.542f, -1.104f, 2.646f)
                quadToRelative(-1.104f, 1.104f, -2.646f, 1.104f)
                close()
                moveTo(35.25f, 17f)
                quadToRelative(-3.292f, -2.75f, -7.125f, -4.333f)
                quadToRelative(-3.833f, -1.584f, -8.125f, -1.584f)
                quadToRelative(-1.333f, 0f, -2.458f, 0.146f)
                quadToRelative(-1.125f, 0.146f, -1.959f, 0.396f)
                lineToRelative(-3.291f, -3.292f)
                quadToRelative(1.75f, -0.583f, 3.687f, -0.895f)
                quadToRelative(1.938f, -0.313f, 4.021f, -0.313f)
                quadToRelative(5.167f, 0f, 9.771f, 1.896f)
                quadToRelative(4.604f, 1.896f, 8.271f, 5.187f)
                quadToRelative(0.625f, 0.542f, 0.625f, 1.354f)
                quadToRelative(0f, 0.813f, -0.625f, 1.396f)
                quadToRelative(-0.542f, 0.542f, -1.354f, 0.563f)
                quadToRelative(-0.813f, 0.021f, -1.438f, -0.521f)
                close()
                moveToRelative(-6.333f, 6.917f)
                quadToRelative(-0.834f, -0.709f, -1.563f, -1.209f)
                quadToRelative(-0.729f, -0.5f, -1.646f, -1f)
                lineToRelative(-5f, -4.958f)
                quadToRelative(3.084f, 0.125f, 5.709f, 1.229f)
                quadToRelative(2.625f, 1.104f, 4.875f, 3.021f)
                quadToRelative(0.583f, 0.5f, 0.604f, 1.292f)
                quadToRelative(0.021f, 0.791f, -0.604f, 1.416f)
                quadToRelative(-0.459f, 0.5f, -1.146f, 0.542f)
                quadToRelative(-0.688f, 0.042f, -1.229f, -0.333f)
                close()
                moveToRelative(3.416f, 12.125f)
                lineTo(17.208f, 20.958f)
                quadToRelative(-1.666f, 0.375f, -3.083f, 1.104f)
                quadToRelative(-1.417f, 0.73f, -2.625f, 1.688f)
                quadToRelative(-0.667f, 0.542f, -1.458f, 0.5f)
                quadToRelative(-0.792f, -0.042f, -1.375f, -0.583f)
                quadToRelative(-0.584f, -0.584f, -0.563f, -1.375f)
                quadToRelative(0.021f, -0.792f, 0.604f, -1.292f)
                quadToRelative(1.125f, -1f, 2.417f, -1.771f)
                quadToRelative(1.292f, -0.771f, 2.917f, -1.437f)
                lineToRelative(-4.167f, -4.167f)
                quadToRelative(-1.417f, 0.667f, -2.688f, 1.542f)
                quadToRelative(-1.27f, 0.875f, -2.437f, 1.833f)
                quadToRelative(-0.625f, 0.542f, -1.438f, 0.521f)
                quadToRelative(-0.812f, -0.021f, -1.395f, -0.604f)
                quadToRelative(-0.584f, -0.584f, -0.584f, -1.375f)
                quadToRelative(0f, -0.792f, 0.625f, -1.334f)
                quadToRelative(1.167f, -1.041f, 2.396f, -1.937f)
                quadToRelative(1.229f, -0.896f, 2.563f, -1.604f)
                lineTo(4f, 7.708f)
                quadToRelative(-0.375f, -0.333f, -0.375f, -0.896f)
                quadToRelative(0f, -0.562f, 0.417f, -0.937f)
                quadToRelative(0.333f, -0.375f, 0.896f, -0.375f)
                quadToRelative(0.562f, 0f, 0.979f, 0.375f)
                lineToRelative(28.291f, 28.333f)
                quadToRelative(0.375f, 0.375f, 0.375f, 0.938f)
                quadToRelative(0f, 0.562f, -0.375f, 0.896f)
                quadToRelative(-0.375f, 0.416f, -0.937f, 0.416f)
                quadToRelative(-0.563f, 0f, -0.938f, -0.416f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberFindReplace(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "FindReplace",
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
                moveTo(75.2f, 15.8f)
                curveToRelative(-27.5f, 8.5f, -52f, 33.3f, -60.1f, 61.1f)
                lineToRelative(-4.8f, 15.3f)
                horizontalLineToRelative(14.6f)
                curveToRelative(13.6f, 0f, 14.9f, -0.7f, 16.6f, -10.2f)
                curveToRelative(3.1f, -14.3f, 26.1f, -36.3f, 43.8f, -41.1f)
                curveToRelative(18.3f, -4.8f, 40.7f, -1.7f, 56f, 7.5f)
                lineToRelative(11.9f, 7.5f)
                lineToRelative(-18f, 18f)
                lineToRelative(-18f, 18.3f)
                horizontalLineToRelative(41.4f)
                horizontalLineToRelative(41.4f)
                verticalLineTo(50.7f)
                verticalLineTo(9.3f)
                lineToRelative(-14.3f, 13.9f)
                lineToRelative(-14.6f, 14.3f)
                lineTo(161.1f, 29f)
                curveTo(140.7f, 12.4f, 104.1f, 6.6f, 75.2f, 15.8f)
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
                moveTo(10f, 159.1f)
                verticalLineToRelative(39.7f)
                lineToRelative(13.2f, -12.9f)
                lineTo(36.5f, 173f)
                lineToRelative(13.9f, 10.2f)
                curveToRelative(27.2f, 19.7f, 64.9f, 22.4f, 96.8f, 7.1f)
                lineToRelative(15.6f, -7.8f)
                lineToRelative(32.3f, 31.9f)
                lineToRelative(32.3f, 32.3f)
                lineToRelative(9.2f, -9.5f)
                lineToRelative(9.5f, -9.2f)
                lineToRelative(-24.1f, -24.5f)
                curveToRelative(-41.8f, -43.5f, -40.1f, -41.1f, -33.6f, -54f)
                curveToRelative(3.4f, -6.1f, 7.1f, -15.3f, 8.8f, -20.7f)
                curveToRelative(2.7f, -9.5f, 2.4f, -9.5f, -12.6f, -9.5f)
                curveToRelative(-11.9f, 0f, -14.9f, 1f, -14.9f, 6.1f)
                curveToRelative(0f, 9.2f, -15.3f, 29.9f, -28.2f, 37.7f)
                curveToRelative(-22.4f, 13.9f, -57.4f, 12.6f, -77.1f, -3.1f)
                lineToRelative(-8.5f, -6.5f)
                lineToRelative(17f, -17.3f)
                lineToRelative(16.6f, -17f)
                horizontalLineTo(49.7f)
                horizontalLineTo(10f)
                verticalLineTo(159.1f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberVoice(color: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "settings_voice",
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
                moveTo(13.208f, 39.833f)
                quadToRelative(-0.583f, 0f, -0.958f, -0.395f)
                quadToRelative(-0.375f, -0.396f, -0.375f, -0.98f)
                quadToRelative(0f, -0.583f, 0.375f, -0.958f)
                reflectiveQuadToRelative(0.958f, -0.375f)
                quadToRelative(0.584f, 0f, 0.98f, 0.375f)
                quadToRelative(0.395f, 0.375f, 0.395f, 0.958f)
                quadToRelative(0f, 0.584f, -0.395f, 0.98f)
                quadToRelative(-0.396f, 0.395f, -0.98f, 0.395f)
                close()
                moveToRelative(6.792f, 0f)
                quadToRelative(-0.583f, 0f, -0.958f, -0.395f)
                quadToRelative(-0.375f, -0.396f, -0.375f, -0.98f)
                quadToRelative(0f, -0.541f, 0.375f, -0.937f)
                reflectiveQuadToRelative(0.958f, -0.396f)
                quadToRelative(0.583f, 0f, 0.979f, 0.375f)
                reflectiveQuadToRelative(0.396f, 0.958f)
                quadToRelative(0f, 0.584f, -0.396f, 0.98f)
                quadToRelative(-0.396f, 0.395f, -0.979f, 0.395f)
                close()
                moveToRelative(6.792f, 0f)
                quadToRelative(-0.584f, 0f, -0.959f, -0.395f)
                quadToRelative(-0.375f, -0.396f, -0.375f, -0.98f)
                quadToRelative(0f, -0.583f, 0.375f, -0.958f)
                reflectiveQuadToRelative(0.959f, -0.375f)
                quadToRelative(0.583f, 0f, 0.979f, 0.375f)
                reflectiveQuadToRelative(0.396f, 0.958f)
                quadToRelative(0f, 0.584f, -0.396f, 0.98f)
                quadToRelative(-0.396f, 0.395f, -0.979f, 0.395f)
                close()
                moveTo(20f, 22.625f)
                quadToRelative(-1.833f, 0f, -3.062f, -1.313f)
                quadToRelative(-1.23f, -1.312f, -1.23f, -3.187f)
                verticalLineTo(7.958f)
                quadToRelative(0f, -1.791f, 1.25f, -3.041f)
                reflectiveQuadTo(20f, 3.667f)
                quadToRelative(1.792f, 0f, 3.042f, 1.25f)
                quadToRelative(1.25f, 1.25f, 1.25f, 3.041f)
                verticalLineToRelative(10.167f)
                quadToRelative(0f, 1.875f, -1.23f, 3.187f)
                quadToRelative(-1.229f, 1.313f, -3.062f, 1.313f)
                close()
                moveToRelative(0f, -9.5f)
                close()
                moveToRelative(0f, 21.708f)
                quadToRelative(-0.542f, 0f, -0.917f, -0.375f)
                reflectiveQuadToRelative(-0.375f, -0.958f)
                verticalLineToRelative(-4.125f)
                quadToRelative(-4f, -0.458f, -6.791f, -3.208f)
                quadToRelative(-2.792f, -2.75f, -3.25f, -6.625f)
                quadToRelative(-0.084f, -0.584f, 0.312f, -1f)
                quadToRelative(0.396f, -0.417f, 1.021f, -0.417f)
                quadToRelative(0.458f, 0f, 0.833f, 0.354f)
                quadToRelative(0.375f, 0.354f, 0.459f, 0.854f)
                quadToRelative(0.458f, 3.209f, 2.896f, 5.334f)
                quadToRelative(2.437f, 2.125f, 5.812f, 2.125f)
                quadToRelative(3.375f, 0f, 5.812f, -2.125f)
                quadToRelative(2.438f, -2.125f, 2.896f, -5.334f)
                quadToRelative(0.084f, -0.5f, 0.459f, -0.854f)
                reflectiveQuadToRelative(0.875f, -0.354f)
                quadToRelative(0.583f, 0f, 0.979f, 0.417f)
                quadToRelative(0.396f, 0.416f, 0.312f, 1f)
                quadToRelative(-0.458f, 3.875f, -3.25f, 6.625f)
                quadToRelative(-2.791f, 2.75f, -6.75f, 3.208f)
                verticalLineTo(33.5f)
                quadToRelative(0f, 0.583f, -0.395f, 0.958f)
                quadToRelative(-0.396f, 0.375f, -0.938f, 0.375f)
                close()
                moveToRelative(0f, -14.875f)
                quadToRelative(0.75f, 0f, 1.208f, -0.52f)
                quadToRelative(0.459f, -0.521f, 0.459f, -1.313f)
                verticalLineTo(7.958f)
                quadToRelative(0f, -0.708f, -0.479f, -1.187f)
                quadToRelative(-0.48f, -0.479f, -1.188f, -0.479f)
                reflectiveQuadToRelative(-1.188f, 0.479f)
                quadToRelative(-0.479f, 0.479f, -0.479f, 1.187f)
                verticalLineToRelative(10.167f)
                quadToRelative(0f, 0.792f, 0.459f, 1.313f)
                quadToRelative(0.458f, 0.52f, 1.208f, 0.52f)
                close()
            }
        }.build()
    }
}