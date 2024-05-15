/*
 * Unitto is a calculator for Android
 * Copyright (c) 2022-2024 Elshan Agaev
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

package app.myzel394.numberhub.feature.settings

import android.content.ActivityNotFoundException
import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.RateReview
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Vibration
import androidx.compose.material.icons.filled._123
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.NewReleases
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.myzel394.numberhub.core.base.BuildConfig
import app.myzel394.numberhub.core.base.R
import app.myzel394.numberhub.core.ui.LocalWindowSize
import app.myzel394.numberhub.core.ui.WindowWidthSizeClass
import app.myzel394.numberhub.core.ui.common.DrawerButton
import app.myzel394.numberhub.core.ui.common.EmptyScreen
import app.myzel394.numberhub.core.ui.common.Header
import app.myzel394.numberhub.core.ui.common.ListItem
import app.myzel394.numberhub.core.ui.common.ScaffoldWithLargeTopBar
import app.myzel394.numberhub.core.ui.openLink
import app.myzel394.numberhub.core.ui.showToast
import app.myzel394.numberhub.feature.settings.components.AnnoyingBox
import app.myzel394.numberhub.feature.settings.navigation.ABOUT_ROUTE
import app.myzel394.numberhub.feature.settings.navigation.CALCULATOR_SETTINGS_ROUTE
import app.myzel394.numberhub.feature.settings.navigation.CONVERTER_SETTINGS_ROUTE
import app.myzel394.numberhub.feature.settings.navigation.DISPLAY_ROUTE
import app.myzel394.numberhub.feature.settings.navigation.FORMATTING_ROUTE
import app.myzel394.numberhub.feature.settings.navigation.STARTING_SCREEN_ROUTE
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
internal fun SettingsRoute(
    viewModel: SettingsViewModel = hiltViewModel(),
    openDrawer: () -> Unit,
    navControllerAction: (String) -> Unit,
) {
    val mContext = LocalContext.current
    val uiState: SettingsUIState = viewModel.uiState
        .collectAsStateWithLifecycle().value
    val showErrorToast: Boolean = viewModel.showErrorToast
        .collectAsStateWithLifecycle(initialValue = false).value

    LaunchedEffect(showErrorToast) {
        if (showErrorToast) showToast(mContext, mContext.resources.getString(R.string.error_label))
    }

    when (uiState) {
        SettingsUIState.Loading -> EmptyScreen()

        is SettingsUIState.Ready -> SettingsScreen(
            uiState = uiState,
            openDrawer = openDrawer,
            navControllerAction = navControllerAction,
            onHasSeenNewAppAnnouncement = viewModel::updateHasSeenNewAppAnnouncement,
            updateLastReadChangelog = viewModel::updateLastReadChangelog,
            updateVibrations = viewModel::updateVibrations,
            clearCache = viewModel::clearCache,
            backup = viewModel::backup,
            restore = viewModel::restore,
        )
    }
}

@Composable
private fun SettingsScreen(
    uiState: SettingsUIState.Ready,
    openDrawer: () -> Unit,
    navControllerAction: (String) -> Unit,
    updateLastReadChangelog: (String) -> Unit,
    updateVibrations: (Boolean) -> Unit,
    onHasSeenNewAppAnnouncement: (Boolean) -> Unit,
    clearCache: () -> Unit,
    backup: (Context, Uri) -> Unit,
    restore: (Context, Uri) -> Unit,
) {
    val mContext = LocalContext.current
    var showMenu by remember { mutableStateOf(false) }

    // Pass picked file uri to BackupManager
    val restoreLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument(),
    ) { pickedUri ->
        if (pickedUri != null) restore(mContext, pickedUri)
    }

    // Pass picked file uri to BackupManager
    val backupLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.CreateDocument(BACKUP_MIME_TYPE),
    ) { pickedUri ->
        if (pickedUri != null) backup(mContext, pickedUri)
    }

    BackHandler(uiState.backupInProgress) {}

    ScaffoldWithLargeTopBar(
        title = stringResource(R.string.settings_title),
        navigationIcon = {
            if (LocalWindowSize.current.widthSizeClass != WindowWidthSizeClass.Expanded) {
                DrawerButton(openDrawer)
            }
        },
        actions = {
            IconButton(
                onClick = { showMenu = !showMenu },
                content = { Icon(Icons.Default.MoreVert, null) },
            )
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
            ) {
                DropdownMenuItem(
                    onClick = {
                        showMenu = false
                        backupLauncher.launchSafely(backupFileName())
                    },
                    text = { Text(stringResource(R.string.settings_back_up)) },
                )
                DropdownMenuItem(
                    onClick = {
                        showMenu = false
                        restoreLauncher.launchSafely(arrayOf(BACKUP_MIME_TYPE))
                    },
                    text = { Text(stringResource(R.string.settings_restore)) },
                )
            }
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding),
        ) {
            var showNewAppInfo by rememberSaveable {
                mutableStateOf(false)
            }

            if (showNewAppInfo) {
                AlertDialog(
                    icon = {
                        Icon(Icons.Outlined.CheckCircle, null)
                    },
                    title = {
                        Text(stringResource(R.string.settings_numberhub_newApp))
                    },
                    text = {
                        Text(stringResource(R.string.settings_numberhub_newApp_announcement))
                    },
                    confirmButton = {
                        TextButton(onClick = { showNewAppInfo = false }) {
                            Text(stringResource(R.string.ok_label))
                        }
                    },
                    onDismissRequest = { showNewAppInfo = false },
                )
            }

            AnimatedVisibility(
                visible = !uiState.hasSeenNewAppAnnouncement,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut(),
            ) {
                val title = stringResource(R.string.settings_numberhub_newApp)
                AnnoyingBox(
                    modifier = Modifier
                        .padding(16.dp, 8.dp)
                        .fillMaxWidth(),
                    imageVector = Icons.Outlined.CheckCircle,
                    imageVectorContentDescription = title,
                    title = title,
                    support = stringResource(R.string.settings_numberhub_newApp_message),
                ) {
                    showNewAppInfo = true
                    //onHasSeenNewAppAnnouncement(true)
                }
            }

            AnimatedVisibility(
                // TODO: Restore this line for next update
                visible = false,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut(),
            ) {
                val title = stringResource(R.string.settings_updated, stringResource(R.string.app_name))
                AnnoyingBox(
                    modifier = Modifier
                        .padding(16.dp, 8.dp)
                        .fillMaxWidth(),
                    imageVector = Icons.Outlined.NewReleases,
                    imageVectorContentDescription = title,
                    title = title,
                    support = stringResource(R.string.settings_updated_support, BuildConfig.VERSION_NAME),
                ) {
                    openLink(mContext, "https://github.com/sadellie/unitto/releases/latest")
                    updateLastReadChangelog(BuildConfig.VERSION_CODE)
                }
            }

            ListItem(
                icon = Icons.Default.Palette,
                headlineText = stringResource(R.string.settings_display),
                supportingText = stringResource(R.string.settings_display_support),
                modifier = Modifier.clickable { navControllerAction(DISPLAY_ROUTE) },
            )

            ListItem(
                icon = Icons.Default.Home,
                headlineText = stringResource(R.string.settings_starting_screen),
                supportingText = stringResource(R.string.settings_starting_screen_support),
                modifier = Modifier.clickable { navControllerAction(STARTING_SCREEN_ROUTE) },
            )

            ListItem(
                icon = Icons.Default._123,
                headlineText = stringResource(R.string.settings_formatting),
                supportingText = stringResource(R.string.settings_formatting_support),
                modifier = Modifier.clickable { navControllerAction(FORMATTING_ROUTE) },
            )

            ListItem(
                icon = Icons.Default.Calculate,
                headlineText = stringResource(R.string.calculator_title),
                supportingText = stringResource(R.string.settings_calculator_support),
                modifier = Modifier.clickable { navControllerAction(CALCULATOR_SETTINGS_ROUTE) },
            )

            ListItem(
                icon = Icons.Default.SwapHoriz,
                headlineText = stringResource(R.string.unit_converter_title),
                supportingText = stringResource(R.string.settings_converter_support),
                modifier = Modifier.clickable { navControllerAction(CONVERTER_SETTINGS_ROUTE) },
            )

            Header(stringResource(R.string.settings_additional))

            ListItem(
                icon = Icons.Default.Vibration,
                headlineText = stringResource(R.string.settings_vibrations),
                supportingText = stringResource(R.string.settings_vibrations_support),
                modifier = Modifier.clickable { navControllerAction(CONVERTER_SETTINGS_ROUTE) },
                switchState = uiState.enableVibrations,
                onSwitchChange = updateVibrations,
            )

            AnimatedVisibility(
                visible = uiState.cacheSize > 0,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut(),
            ) {
                ListItem(
                    headlineText = stringResource(R.string.settings_clear_cache),
                    icon = Icons.Default.Cached,
                    modifier = Modifier.clickable {
                        clearCache()
                        showToast(mContext, "👌")
                    },
                )
            }

            ListItem(
                icon = Icons.Default.Info,
                headlineText = stringResource(R.string.settings_about_unitto),
                supportingText = stringResource(R.string.settings_about_unitto_support),
                modifier = Modifier.clickable { navControllerAction(ABOUT_ROUTE) },
            )
        }
    }

    AnimatedVisibility(
        visible = uiState.backupInProgress,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Scaffold { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

private fun <T> ActivityResultLauncher<T>.launchSafely(input: T) {
    try {
        this.launch(input)
    } catch (e: ActivityNotFoundException) {
        Log.e("SettingsScreen", "launchSafely: ActivityNotFoundException")
    }
}

private fun backupFileName(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss")
    return "${ZonedDateTime.now().format(formatter)}.unitto"
}

private const val BACKUP_MIME_TYPE = "application/octet-stream"

@Preview
@Composable
private fun PreviewSettingsScreen() {
    val corScope = rememberCoroutineScope()
    var uiState by remember {
        mutableStateOf(
            SettingsUIState.Ready(
                enableVibrations = false,
                cacheSize = 2,
                backupInProgress = false,
                showUpdateChangelog = true,
                hasSeenNewAppAnnouncement = false,
            ),
        )
    }

    SettingsScreen(
        uiState = uiState,
        openDrawer = {},
        navControllerAction = {},
        onHasSeenNewAppAnnouncement = {
            uiState = uiState.copy(hasSeenNewAppAnnouncement = true)
        },
        updateLastReadChangelog = {
            uiState = uiState.copy(showUpdateChangelog = false)
        },
        updateVibrations = {},
        clearCache = {
            uiState = uiState.copy(cacheSize = 0)
        },
        backup = { _, _ ->
            corScope.launch {
                uiState = uiState.copy(backupInProgress = true)
                delay(2000)
                uiState = uiState.copy(backupInProgress = false)
            }
        },
        restore = { _, _ ->
            corScope.launch {
                uiState = uiState.copy(backupInProgress = true)
                delay(2000)
                uiState = uiState.copy(backupInProgress = false)
            }
        },
    )
}
