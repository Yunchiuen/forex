# 功能說明

1.批次每日18:00呼叫API，取得外匯成交資料
GET http://localhost:8080/forex/Save

![batch](https://github.com/Yunchiuen/forex/assets/64777402/128a25e8-befd-4e54-80cb-f316152691bd)

2.從DB取出日期區間內幣別資料
POST http://localhost:8080/forex/query
![image](https://github.com/Yunchiuen/forex/assets/64777402/3266ffda-62ed-4630-b15a-35e40b3e2fb1)

日期區間僅限1年前~當下日期-1天
![image](https://github.com/Yunchiuen/forex/assets/64777402/ff14861d-a8fd-4ae9-876e-ace94e5cf2c2)

日期格式錯誤
![image](https://github.com/Yunchiuen/forex/assets/64777402/25adc95f-0b81-449e-bb09-7ff42f3c676d)

幣別輸入錯誤
![image](https://github.com/Yunchiuen/forex/assets/64777402/ae9aab58-2deb-4d25-b8d2-cb367cf47933)

傳入參數為空
![image](https://github.com/Yunchiuen/forex/assets/64777402/62faab65-543f-47bc-9fbd-b939287f3ab5)

也可以使用 ForexTest 的 testFetchForex方法進行測試
![image](https://github.com/Yunchiuen/forex/assets/64777402/cf8cc15e-f515-4a1e-b4b0-61bf82df9590)
