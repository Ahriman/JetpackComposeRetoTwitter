package com.example.jetpackcomposeretotwitter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Twit() {
    Row(Modifier.padding(6.dp)) {
        Avatar(Modifier.weight(1f))
        Content(Modifier.weight(4f))
    }
}

@Composable
fun Content(modifier: Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxHeight()
            .padding(start = 12.dp, top = 18.dp, end = 16.dp)
    ) {
        item { Header(modifier) }
        item { Body(modifier) }
        item { Footer(modifier) }
    }
}

@Composable
fun Footer(modifier: Modifier) {
    var comments by rememberSaveable { mutableStateOf(1) }
    var retweets by rememberSaveable { mutableStateOf(1) }
    var likes by rememberSaveable { mutableStateOf(1) }
    var commented by rememberSaveable { mutableStateOf(false) }
    var retweeted by rememberSaveable { mutableStateOf(false) }
    var liked by rememberSaveable { mutableStateOf(false) }
    var imageComment by rememberSaveable { mutableStateOf(R.drawable.ic_chat) }
    var imageRetweet by rememberSaveable { mutableStateOf(R.drawable.ic_rt) }
    var imageLike by rememberSaveable { mutableStateOf(R.drawable.ic_like) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {
                commented = !commented

                imageComment = if (commented) R.drawable.ic_chat_filled
                else R.drawable.ic_chat

                if (commented) comments++ else comments--
            }) {
                Icon(
                    painter = painterResource(imageComment),
                    contentDescription = "comments",
                )
            }
            Text(text = comments.toString(), fontSize = 10.sp)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {
                retweeted = !retweeted
                if (retweeted) retweets++ else retweets--
            }) {
                val color = if (retweeted) Color.Green else MaterialTheme.colors.onBackground
                Icon(
                    painter = painterResource(imageRetweet),
                    contentDescription = "retweets",
                    tint = color
                )
            }
            Text(text = retweets.toString(), fontSize = 10.sp)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {
                liked = !liked

                imageLike = if (liked) R.drawable.ic_like_filled
                else R.drawable.ic_like

                if (liked) likes++ else likes--
            }) {
                val color = if (liked) Color.Red else MaterialTheme.colors.onBackground
                Icon(
                    painter = painterResource(imageLike),
                    contentDescription = "likes",
                    tint = color
                )
            }
            Text(text = likes.toString(), fontSize = 10.sp)
        }
    }
}

@Composable
fun Body(modifier: Modifier) {
    Text(text = "Descripción larga sobre texto lallalala lolololoo lelelele\nDescripción larga sobre texto\nDescripción larga sobre texto\nDescripción larga sobre texto\nDescripción larga sobre texto\n")
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "image post",
        modifier = Modifier.clip(shape = RoundedCornerShape(32.dp))
    )
}

@Composable
fun Header(modifier: Modifier) {
    Row(
        Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row() {
            Text(text = "Aris")
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = "@ArisDevs")
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = "4h")
            Spacer(modifier = Modifier.padding(8.dp))
        }
        Row() {
            Image(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "options",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
            )
        }
    }
}

@Composable
fun Avatar(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "avatar",
        modifier = modifier
            .padding(top = 16.dp)
            .width(120.dp)
            .clip(CircleShape)
    )
}
