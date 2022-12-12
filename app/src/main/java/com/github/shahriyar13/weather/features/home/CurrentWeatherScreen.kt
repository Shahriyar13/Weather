package com.github.shahriyar13.weather.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.shahriyar13.weather.ui.theme.Pink80
import com.github.shahriyar13.weather.ui.theme.Purple80

@Composable
fun CurrentWeatherScreen(viewModel: CurrentWeatherViewModel = hiltViewModel()) {
    val scrollStateScreen = rememberScrollState()
    val isLoading by remember { viewModel.isLoading }
    val loadError by remember { viewModel.loadError }
    if (!isLoading && loadError.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .verticalScroll(scrollStateScreen)
        ) {
            TodayDateBox()
            CurrentWeatherBox()
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Next Days",//TODO: move to resources
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                )
            }
            DailyWeatherList()
        }
    } else if (loadError.isNotEmpty()) {
        RetrySection(error = loadError) {
            viewModel.loadCurrentWeatherData()
            viewModel.loadDailyWeatherData()
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(color = Color.Cyan)
        }
    }
}

@Composable
fun TodayDateBox(viewModel: CurrentWeatherViewModel = hiltViewModel()) {
    val currentDate by remember { viewModel.currentDate }
    val isLoading by remember { viewModel.isLoading }
    val loadingError by remember { viewModel.loadError }
    if (!isLoading) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Surface(
                shape = RoundedCornerShape(32.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = currentDate,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(8.dp),
                        fontSize = 19.sp
                    )
                }
            }
        }
    } else {
        Text(text = loadingError) //TODO: show snackBar
    }
}

@Composable
fun CurrentWeatherBox(viewModel: CurrentWeatherViewModel = hiltViewModel()) {


    val currentTemp by remember { viewModel.currentTemp }
    val currentWeatherType by remember { viewModel.currentWeatherType }
    val currentHumidity by remember { viewModel.currentHumidity }
    val currentUV by remember { viewModel.currentUV }
    val currentImgUrl by remember { viewModel.currentImgUrl }
    val isLoading by remember { viewModel.isLoading }

    if (!isLoading) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 4.dp, 16.dp, 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Purple80)
                    .padding(4.dp)
            ) {
                Column {
                    Text(
                        text = currentTemp,
                        color = Color.White,
                        fontSize = 72.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Text(
                        text = currentWeatherType,
                        color = Color.White,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(PaddingValues(0.dp, 0.dp, 24.dp, 8.dp)),
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
//                                Image(
//                                    painter = painterResource(id = R.drawable.ic_humidity),
//                                    contentDescription = stringResource(R.string.description)
//                                )
                                Text(
                                    text = "Humidity $currentHumidity",
                                    color = Color.White,
                                    modifier = Modifier
                                        .padding(6.dp, 12.dp),
                                    fontSize = 18.sp
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
//                                Image(
//                                    painter = painterResource(id = R.drawable.ic_wind),
//                                    contentDescription = stringResource(R.string.description)
//                                )
                                Text(
                                    text = "UV $currentUV",
                                    modifier = Modifier
                                        .padding(6.dp, 12.dp),
                                    fontSize = 18.sp
                                )
                            }
                        }

//                        Image(
//                            painter = painterResource(id = getImageFromUrl(currentImgUrl)),
//                            contentDescription = stringResource(R.string.description),
//                            modifier = Modifier.size(120.dp)
//                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DailyWeatherList(viewModel: CurrentWeatherViewModel = hiltViewModel()) {
    val dailyWeatherList by remember { viewModel.dailyWeatherList }
    val isLoading by remember { viewModel.isLoading }

    LazyRow {
        items(dailyWeatherList) {
            if (!isLoading) {
                DailyWeatherBox(
                    time = it.date.toString(),
                    imgUrl = it.weatherDetailsList.first().icon,
                    temp = it.weatherDetailsList.first().main,
                    tempHigh = it.temperature.max.toString(),
                    tempLow = it.temperature.min.toString()
                )
            }
        }
    }
}

@Composable
fun DailyWeatherBox(
    time: String,
    imgUrl: String,
    temp: String,
    tempHigh: String,
    tempLow: String
) {
    Box(modifier = Modifier.padding(8.dp, 4.dp)) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Pink80)
                .padding(4.dp)
                .size(width = 200.dp, height = 270.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = time,
                    color = Color.White,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(0.dp, 8.dp, 0.dp, 8.dp))
                )

//                Image(
//                    painter = painterResource(id = getImageFromUrl(imgUrl)),
//                    contentDescription = stringResource(R.string.description),
//                    modifier = Modifier.size(96.dp)
//                )

                Text(
                    text = temp,
                    color = Color.White,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(0.dp, 0.dp, 0.dp, 8.dp))
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(24.dp, 0.dp)
                    ) {
//                        Icon(
//                            Icons.Outlined.ExpandMore,
//                            contentDescription = stringResource(R.string.description),
//                            modifier = Modifier.size(40.dp),
//                            Color.White
//                        )
                        Text(
                            text = tempLow,
                            color = Color.White,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(PaddingValues(0.dp, 0.dp, 0.dp, 8.dp))
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(24.dp, 0.dp)
                    ) {
//                        Icon(
//                            Icons.Filled.ExpandLess,
//                            contentDescription = stringResource(R.string.description),
//                            modifier = Modifier.size(40.dp),
//                            Color.White
//                        )
                        Text(
                            text = tempHigh,
                            color = Color.White,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(PaddingValues(0.dp, 0.dp, 0.dp, 8.dp))
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RetrySection(
    error: String,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(error, color = Color.Red, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { onRetry() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Retry", color = Color.White)// TODO: Move to resources
        }
    }
}
