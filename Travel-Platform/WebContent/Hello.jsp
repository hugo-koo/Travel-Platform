<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="Hello"%>
<!DOCTYPE html>
<html>

<head>
    <%-- 导入站点全局首部--%>
    <%@ include file="/site-head.jsp"%>
</head>

<body>
    <%@ include file="/site-header.jsp"%>
    <hr>
    <div id="cardWelcome"></div>
    <script type="text/babel">
        const {
            Grid,
            makeStyles,
            Card,
            CardActionArea,
            CardActions,
            CardContent,
            CardMedia,
            Button,
            Typography,
        } = MaterialUI;

        const useStyles = makeStyles({
            root: {
                maxWidth: 345,
            },
            media: {
                height: 140,
                width: 345,
            },
        });

        function MediaCard() {
            const classes = useStyles();

            return (
                <Grid container spacing={1} direction="row" justify="center" alignItems="center">
                    <Card className={classes.root}>
                        <CardActionArea>
                            <CardMedia
                                className={classes.media}
                                image="/Travel-Platform/_media/青岛_樱花.png"
                                title="Contemplative Reptile"
                            />
                            <CardContent>
                                <Typography gutterBottom variant="h5" component="h2">
                                    <%out.print("欢迎访问");%>
                                  </Typography>
                                <Typography variant="body2" color="textSecondary" component="p">
                                    <%out.print("这里是旅游服务平台的测试页面");%>
                                  </Typography>
                            </CardContent>
                        </CardActionArea>
                        <CardActions>
                            <a href="/Travel-Platform/index.jsp">
                                <Button size="small" color="primary">
                                    <%out.print("去首页");%>
                                </Button>
                            </a>
                        </CardActions>
                    </Card>
                </Grid>
            );
        }

        ReactDOM.render(<MediaCard />, document.querySelector('#cardWelcome'));
    </script>
</body>

</html>