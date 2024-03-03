package com.ramo.ebuy.ui.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.base.outlinedTextFieldStyle
import com.ramo.ebuy.global.ui.rememberDone
import com.seiko.imageloader.rememberImagePainter
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
            text = item.title,
            color = theme.textHintColor,
            fontSize = 16.sp,
            maxLines = 3,
            minLines = 3,
            overflow = TextOverflow.Ellipsis,
        )
        item.timeGap?.let {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "$" + item.offer.toString(),
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
                text = item.title,
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
                    text = "$" + item.offer.toString(),
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
                        imageVector = if (item.isWatchlist) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
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
                        imageVector = if (item.isWatchlist) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
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
fun ProductWatchListItem(
    item: Product,
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
                text = item.title,
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
                    text = "$" + item.offer.toString(),
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
                }
            }
        }
    }
}

@Composable
fun ProductUserCartItem(
    item: Product,
    onQuantityChanged: (Product, Int) -> Unit,
    onClick: (Product) -> Unit,
    theme: Theme = koinInject(),
) {
    val stateQuantity = remember {
        mutableStateOf(item.cartQuantity.toString())
    }
    val notSame = stateQuantity.value.toIntOrNull().let { it != null && it  != item.cartQuantity }
    val painter = rememberImagePainter(url = item.imageUris.firstOrNull() ?: "")
    Row(
        modifier = Modifier.clickable {
            onClick(item)
        }
    ) {
        Column {
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
            Spacer(Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .width(120.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    modifier = Modifier.width(110.dp),
                    value = stateQuantity.value,
                    onValueChange = { name ->
                        stateQuantity.value = name
                    },
                    shape = RoundedCornerShape(12.dp),
                    label = { Text(text = "Quantity", fontSize = 14.sp) },
                    isError = stateQuantity.value.toIntOrNull() == null,
                    singleLine = true,
                    colors = theme.outlinedTextFieldStyle(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                )
                Spacer(Modifier.height(10.dp))
                Image(
                    modifier = Modifier
                        .clickable {
                            stateQuantity.value.toIntOrNull()?.let {
                                if (it != item.cartQuantity) {
                                    onQuantityChanged(item, it)
                                }
                            }
                        }
                        .width(40.dp)
                        .height(40.dp)
                        .background(color = if (notSame) Color.Green else theme.backDarkSec, shape = RoundedCornerShape(10.dp))
                        .padding(5.dp),
                    imageVector = rememberDone(if (notSame) Color.Black else theme.textColor),
                    colorFilter = ColorFilter.tint(if (notSame) Color.Black else theme.textColor),
                    contentScale = ContentScale.Fit,
                    contentDescription = null,
                )
            }
        }
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = item.title,
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
                    text = "$" + item.offer.toString(),
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
                }
            }
        }
    }
}

@Composable
fun ExpandableCatoItem(
    catoName: String,
    isTheProduct: Boolean,
    haveChildren: Boolean,
    isExpanded: Boolean,
    theme: Theme = koinInject(),
    onClick: () -> Unit,
    expend: (Boolean) -> Unit,
) {
    Row(
        Modifier.clip(RoundedCornerShape(10.dp)).background(if (isTheProduct) theme.priAlpha else theme.background),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val animated = animateFloatAsState(
            targetValue = if (isExpanded) 180F else 0F,
            label = "round"
        )
        Column(
            Modifier.padding(start = 2.dp).defaultMinSize(minHeight = 50.dp).weight(1F).clickable {
                onClick()
            }, verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier,
                text = catoName,
                color = theme.textColor,
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis,
            )
        }
        if (haveChildren) {
            Button(onClick = {
                expend(isExpanded)
            }, colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)) {
                Image(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .rotate(animated.value),
                    imageVector = Icons.Default.ArrowDropDown,
                    colorFilter = ColorFilter.tint(theme.textColor),
                    contentScale = ContentScale.Fit,
                    contentDescription = "Expandable Category Image",
                )
            }
        } else {
            Spacer(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
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
            HorizontalDivider(modifier = Modifier.padding(10.dp))
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