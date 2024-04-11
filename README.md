# 功能說明

1.批次每日18:00呼叫API，取得外匯成交資料
GET http://localhost:8080/forex/Save

![batch](C:\Users\User\Desktop\新增資料夾\batch.png)

2.從DB取出日期區間內幣別資料

POST http://localhost:8080/forex/query

![SUCCESS](C:\Users\User\Desktop\新增資料夾\SUCCESS.png)

日期區間僅限1年前~當下日期-1天

![ERROR](C:\Users\User\Desktop\新增資料夾\ERROR.png)

日期格式錯誤

![ERROR2](C:\Users\User\Desktop\新增資料夾\ERROR2.png)

幣別輸入錯誤

![ERROR3](C:\Users\User\Desktop\新增資料夾\ERROR3.png)

傳入參數為空

![](C:\Users\User\Desktop\新增資料夾\ERROR4.png)

也可以使用 ForexTest 的 testFetchForex方法進行測試

![test](C:\Users\User\Desktop\新增資料夾\test.png)
