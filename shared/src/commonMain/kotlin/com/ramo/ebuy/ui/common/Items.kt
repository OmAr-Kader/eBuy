package com.ramo.ebuy.ui.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.data.model.Product
import com.seiko.imageloader.rememberImagePainter
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.global.base.Theme
import org.koin.compose.koinInject

@Composable
fun ProductItem(
    item: Product,
    onClick: (Product) -> Unit,
    theme: Theme = koinInject(),
) {
    val painter = rememberImagePainter(url = item.imageUris.firstOrNull() ?: "")
    Column(
        modifier = Modifier
            .width(170.dp)
            .height(300.dp)
            .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)
            .clickable {
                onClick(item)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .width(160.dp)
                .height(160.dp)
                .clip(RoundedCornerShape(20.dp)),
            painter = painter,
            contentScale = ContentScale.Fit,
            contentDescription = "Product Image",
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = item.name,
            color = theme.textHintColor,
            fontSize = 16.sp,
            maxLines = 3,
            minLines = 3,
            overflow = TextOverflow.Ellipsis,
        )
        item.timeGap?.let {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "$" + item.discount.toString(),
                color = theme.textColor,
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            textDecoration = TextDecoration.LineThrough,
                            color = theme.textHintColor,
                            fontSize = 16.sp
                        )
                    ) { // AnnotatedString.Builder
                        append("$" + item.price.toString())
                    }
                    append("." + item.discountPer + "% OFF")
                },
                //text = gap.days.toString() + "d " + gap.hours.toString() + "h",
                color = theme.textHintColor,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        } ?: run {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "$" + item.price.toString(),
                color = theme.textColor,
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun ProductMainSearchItem(
    item: Product,
    favorite: (Product) -> Unit,
    onClick: (Product) -> Unit,
    theme: Theme = koinInject(),
) {
    val painter = rememberImagePainter(url = item.imageUris.firstOrNull() ?: "")
    Row(
        modifier = Modifier.clickable {
            onClick(item)
        }
    ) {
        Image(
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(theme.backDark),
            painter = painter,
            contentDescription = ""
        )
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = item.name,
                color = theme.textColor,
                fontSize = 14.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = item.condition,
                color = theme.textHintColor,
                fontSize = 12.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            item.timeGap?.let {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "$" + item.discount.toString(),
                    color = theme.textColor,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    textDecoration = TextDecoration.LineThrough,
                                    color = theme.textHintColor,
                                    fontSize = 12.sp
                                )
                            ) { // AnnotatedString.Builder
                                append("$" + item.price.toString())
                            }
                            append("." + item.discountPer + "% OFF")
                        },
                        //text = gap.days.toString() + "d " + gap.hours.toString() + "h",
                        color = theme.textHintColor,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Image(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)
                            .padding(7.dp)
                            .clickable {
                                favorite(item)
                            },
                        imageVector = if (item.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        colorFilter = ColorFilter.tint(theme.primary),
                        contentScale = ContentScale.Fit,
                        contentDescription = "Expandable Category Image",
                    )
                }
            } ?: run {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$" + item.price.toString(),
                        color = theme.textColor,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Image(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)
                            .padding(7.dp)
                            .clickable {
                                favorite(item)
                            },
                        imageVector = if (item.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        colorFilter = ColorFilter.tint(theme.primary),
                        contentScale = ContentScale.Fit,
                        contentDescription = "Expandable Category Image",
                    )
                }
            }
        }
    }
}

@Composable
fun ExpandableCatoItem(
    catoName: String,
    isExpanded: Boolean,
    theme: Theme = koinInject(),
) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        val animated = animateFloatAsState(
            targetValue = if (isExpanded) 180F else 0F,
            label = "round"
        )
        Text(
            modifier = Modifier.height(50.dp).weight(1F),
            text = catoName,
            color = theme.textColor,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Button(onClick = {
            isExpanded != isExpanded
        }, colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)) {
            Image(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .rotate(animated.value),
                imageVector = Icons.Default.ArrowDropDown,
                colorFilter = ColorFilter.tint(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = "Expandable Category Image",
            )
        }
    }
}


@Composable
fun GridCatoItem(
    cato: Category,
    isLast: Boolean,
    onClick: (Category) -> Unit,
    theme: Theme = koinInject(),
) {
    val painter = rememberImagePainter(
        url = cato.imageUri,
    )
    Column(modifier = Modifier.width(150.dp).clickable {
        onClick(cato)
    }, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .width(130.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(20.dp)),
            painter = painter,
            contentScale = ContentScale.Fit,
            contentDescription = "Grid Category Image",
        )
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = cato.name,
            color = theme.textColor,
            fontSize = 14.sp,
            maxLines = 2,
            minLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
        if (!isLast) {
            Divider(modifier = Modifier.padding(10.dp))
        }
    }
}


@Composable
fun GridCircleCatoItem(
    cato: Category,
    onClick: (Category) -> Unit,
    theme: Theme = koinInject(),
) {
    val painter = rememberImagePainter(
        url = cato.imageUri,
    )
    Column(modifier = Modifier.width(100.dp).clickable {
        onClick(cato)
    }, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(50.dp)),
            painter = painter,
            contentScale = ContentScale.Fit,
            contentDescription = "Grid Category Image",
        )
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = cato.name,
            color = theme.textColor,
            fontSize = 14.sp,
            maxLines = 2,
            minLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}


@Composable
fun ProfileItem(
    text: String,
    icon: @Composable () -> ImageVector,
    theme: Theme = koinInject(),
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable {
                onClick()
            }
            .padding(15.dp),
        color = Color.Transparent,
        shape = RoundedCornerShape(20.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
                    .padding(3.dp),
                imageVector = icon(),
                colorFilter = ColorFilter.tint(color = theme.textGrayColor),
                contentDescription = "Icon"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = text,
                color = theme.textGrayColor,
                fontSize = 16.sp
            )
        }
    }
}