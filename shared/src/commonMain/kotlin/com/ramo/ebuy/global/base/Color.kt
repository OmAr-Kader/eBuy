package com.ramo.ebuy.global.base

@androidx.compose.runtime.Composable
fun Theme.outlinedTextFieldStyle(): androidx.compose.material3.TextFieldColors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
    focusedBorderColor = textColor,
    errorTextColor = textColor,
    errorSupportingTextColor = error,
    unfocusedBorderColor = textGrayColor,
    focusedPlaceholderColor = textColor,
    unfocusedPlaceholderColor = textHintColor,
    focusedLabelColor = textColor,
    unfocusedLabelColor =  textHintColor,
    focusedTextColor = textColor,
    unfocusedTextColor = textColor,
    errorBorderColor = error,
)
