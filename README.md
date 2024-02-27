**Конвертер валют**

Приложение для конвертации валют принимает числовое значение и буквенный код исходной валюты и буквенный код конвертируемой валюты. 
Результатом является информация о конвертации валют.

В приложении используется *JSR-354(Moneta API)* , который представляет собой готовый API для удобной работы с валютами.
- Предоставление API для обработки и расчета денежных величин;
- Определение классов представляющих валюты и денежные величины;
- Округление и форматирование денежных величин;
- Конвертация валют;

Пример запроса для конвертации валют:
localhost:8080/api/v1/converter/convert?val1=100&name1=USD&name2=EUR

Получить список всех валют:
localhost:8080/api/v1/converter/showAll
