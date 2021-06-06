package com.example.bottomsheets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
@ExperimentalMaterialApi
fun ModelBottomSheet() {
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue =ModalBottomSheetValue.Hidden
    )
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            LazyColumn() {
                items(25) {
                    ListItem(
                        text = { Text("Item $it") },
                        icon = {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Localized description"
                            )
                        }
                    )
                }
            }
        }
    ) {
        ModalBottomSheetMainscreenView(scope, modalBottomSheetState)
    }

}

@ExperimentalMaterialApi
@Composable
fun ModalBottomSheetMainscreenView(
    scope: CoroutineScope,
    modalBottomSheetState: ModalBottomSheetState
) {
    Box(
        Modifier
            .fillMaxWidth()
    ){
        Button(
            modifier = Modifier
                .padding(20.dp)
                .align(alignment = Alignment.TopCenter),
            onClick = {
                scope.launch{
                    modalBottomSheetState.show()
                }
            }
        ) {
            Text(
                text = "Click to show Model Bottom Sheet"
            )
        }
    }
}
