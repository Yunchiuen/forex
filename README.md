# 功能說明

1.批次每日18:00呼叫API，取得外匯成交資料
GET http://localhost:8080/forex/Save

![batch](.\img\batch.png)

2.從DB取出日期區間內幣別資料

POST http://localhost:8080/forex/query

![SUCCESS](.\img\SUCCESS.png)

日期區間僅限1年前~當下日期-1天

![ERROR](.\img\ERROR.png)

日期格式錯誤

![ERROR2](.\img\ERROR2.png)

幣別輸入錯誤

![ERROR3](.\img\ERROR3.png)

傳入參數為空

![](.\img\ERROR4.png)

也可以使用 ForexTest 的 testFetchForex方法進行測試

![test](.\img\test.png)
