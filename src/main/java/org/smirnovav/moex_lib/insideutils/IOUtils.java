package org.smirnovav.moex_lib.insideutils;

import org.smirnovav.moex_lib.collectors.Quote;
import org.smirnovav.moex_lib.enums.SecurityTypes;

import java.io.FileWriter;
import java.io.IOException;

public class IOUtils {
    private IOUtils() {}


    /**
     * Получает ссылку GET запроса информации о торгуемых и торговавшихся на Мосбирже инструментов
     * @param securityType Тип актива
     * @param rowPosition Т.к. информация выдаётся порциями по 100 строк, указывается номер строки с которой нужно выводить информацию
     * @return ссылку GET запроса информации о торгуемых и торговавшихся на Мосбирже инструментов
     */
    public static String getSecuritiesInfoGetRequest(SecurityTypes securityType, int rowPosition) {
        String url = "http://iss.moex.com/iss/securities.json?group_by=type&group_by_filter=";
        return url + securityType.getName() + "&start=" + rowPosition + "&securities.columns=secid,shortname,name";
    }

    /**
     * Выводит котироку в файл с разделителями в виде ","
     *
     * @param pathToFile Путь к файлу
     */
    public static void quoteToFileTxt(Quote quote, String pathToFile) {
        StringBuilder finalInfo;
        String oneString;
        int dec = quote.getDecimals();
        try(FileWriter writer = new FileWriter(pathToFile)) {
            finalInfo = new StringBuilder(quote.getHeader() + "\n");
            for (int i = 0; i < quote.getClose().length; i++) {
                oneString = quote.getTicker()[i] + "," + quote.getTimeframe()[i] + "," + quote.getDate()[i] + "," +
                        quote.getTime()[i] + "," + NumberUtils.getRoundingStringNumber(quote.getOpen()[i], dec) + "," +
                        NumberUtils.getRoundingStringNumber(quote.getHigh()[i], dec) + "," +
                        NumberUtils.getRoundingStringNumber(quote.getLow()[i], dec) + "," +
                        NumberUtils.getRoundingStringNumber(quote.getClose()[i], dec) + "," + quote.getVolume()[i] + "\n";
                finalInfo.append(oneString);
            }
            writer.write(finalInfo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
