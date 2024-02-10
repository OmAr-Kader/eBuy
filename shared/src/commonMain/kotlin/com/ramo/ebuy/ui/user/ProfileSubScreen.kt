package com.ramo.ebuy.ui.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.ui.OnLaunchScreenScope
import com.ramo.ebuy.global.ui.rememberProfile
import com.ramo.ebuy.global.util.profileData
import com.ramo.ebuy.global.util.profileIcons
import com.ramo.ebuy.global.util.urlCheckIfEmpty
import com.ramo.ebuy.ui.common.BarMainScreen
import com.ramo.ebuy.ui.common.ProfileItem
import com.seiko.imageloader.rememberImagePainter
import org.koin.compose.koinInject


@Composable
fun ProfileSubScreen(
    //navigator: Navigator,
    viewModel: HomeViewModel,
    theme: Theme = koinInject()
) {
    val state by viewModel.uiState.collectAsState()
    OnLaunchScreenScope {
        viewModel.loadUserData()
    }
    val painter = state.user?.image.urlCheckIfEmpty?.let {
        rememberImagePainter(url = it)
    }

    Column(Modifier.fillMaxSize()) {
        BarMainScreen(-112)
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn {
            item {
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                        .clickable {

                        }
                ) {
                    Surface(
                        modifier = Modifier.size(70.dp),
                        color = theme.backDark,
                        shape = CircleShape,
                    ) {
                        painter?.let {
                            Image(
                                modifier = Modifier.size(70.dp).padding(top = 10.dp),
                                painter = it,
                                contentScale = ContentScale.Fit,
                                contentDescription = "",
                            )
                        } ?: run {
                            Image(
                                modifier = Modifier.size(70.dp).padding(top = 10.dp),
                                imageVector = rememberProfile(theme.backDarkSec),
                                contentDescription = "",
                                colorFilter = ColorFilter.tint(theme.backDarkSec)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(modifier = Modifier.padding(), text = "User Name", color = theme.textColor, fontSize = 16.sp)
                }
            }
            itemsIndexed(profileData) { i, it ->
                ProfileItem(
                    text = it,
                    icon = {
                        i.profileIcons(theme.textGrayColor)
                    },
                ) {

                }
                if (i == 0 || i == 6) {
                    Divider(color = theme.textColor, modifier = Modifier.padding(horizontal = 30.dp))
                }
            }
        }
    }
}
