/*
 * Unitto is a calculator for Android
 * Copyright (c) 2023-2024 Elshan Agaev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package app.myzel394.numberhub.core.ui.common

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.myzel394.numberhub.core.base.R
import app.myzel394.numberhub.core.ui.model.DrawerItem
import kotlinx.coroutines.delay

@Suppress("UnusedReceiverParameter")
@Composable
internal fun ColumnScope.SheetContent(
    mainTabs: List<DrawerItem>,
    additionalTabs: List<DrawerItem>,
    currentDestination: String?,
    onItemClick: (DrawerItem) -> Unit,
) {
    var showHello by remember { mutableStateOf(false) }
    val interactionSource = remember {
        MutableInteractionSource()
    }
    LaunchedEffect(showHello) {
        if (showHello) {
            delay(2000)
            showHello = false
        }
    }

    AnimatedContent(
        targetState = showHello,
        label = "Hello reveal",
        modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = { showHello = true },
        ),
    ) { hello ->
        Text(
            text = if (hello) stringResource(R.string.hello_label) else stringResource(R.string.app_name),
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 24.dp),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
        )
    }

    mainTabs.forEach { drawerItem ->
        val selected = drawerItem.start == currentDestination
        DrawerItem(
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
            destination = drawerItem,
            icon = if (selected) drawerItem.selectedIcon else drawerItem.defaultIcon,
            selected = selected,
            onClick = onItemClick,
        )
    }

    HorizontalDivider(Modifier.padding(horizontal = 12.dp, vertical = 8.dp))

    additionalTabs.forEach { drawerItem ->
        val selected = drawerItem.start == currentDestination
        DrawerItem(
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
            destination = drawerItem,
            icon = if (selected) drawerItem.selectedIcon else drawerItem.defaultIcon,
            selected = selected,
            onClick = onItemClick,
        )
    }
}

@Preview
@Composable
private fun PreviewDrawerSheet() {
    Column {
        SheetContent(
            mainTabs = listOf(
                DrawerItem.Calculator,
                DrawerItem.Calculator,
                DrawerItem.Calculator,
            ),
            additionalTabs = listOf(
                DrawerItem.Calculator,
                DrawerItem.Calculator,
                DrawerItem.Calculator,
            ),
            currentDestination = DrawerItem.Calculator.start,
            onItemClick = {},
        )
    }
}
