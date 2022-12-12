package com.github.shahriyar13.weather.features.daily

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.shahriyar13.weather.ui.theme.Purple80

@Composable
fun DailyWeatherScreen(viewModel: DailyWeatherViewModel = hiltViewModel()) {
    val scrollStateScreen = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .verticalScroll(scrollStateScreen)
    ) {
        TodayDateBox()
        CurrentWeatherBox()
    }
}

@Composable
fun TodayDateBox(viewModel: DailyWeatherViewModel = hiltViewModel()) {
    val currentDate by remember { viewModel.date }
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
}

@Composable
fun CurrentWeatherBox(viewModel: DailyWeatherViewModel = hiltViewModel()) {


    val morningTemp by remember { viewModel.tempMorning }
    val dayTemp by remember { viewModel.tempDay }
    val eveningTemp by remember { viewModel.tempEvening }
    val nightTemp by remember { viewModel.tempNight }
    val maxTemp by remember { viewModel.tempHigh }
    val minTemp by remember { viewModel.tempLow }

    val currentWeatherType by remember { viewModel.weatherType }
    val currentHumidity by remember { viewModel.humidity }
    val currentUV by remember { viewModel.uvi }
    val currentImgUrl by remember { viewModel.imgUrl }

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
                    text = dayTemp,
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

