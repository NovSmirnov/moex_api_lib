package org.smirnovav.moex_lib.insideutils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.smirnovav.moex_lib.collectors.Candle;
import org.smirnovav.moex_lib.collectors.MoexCandle;
import org.smirnovav.moex_lib.collectors.SecuritySpecification;
import org.smirnovav.moex_lib.jsonparseclasses.candles.Candles;
import org.smirnovav.moex_lib.jsonparseclasses.history.MoexHistory;
import org.smirnovav.moex_lib.mappers.CandleMappers;
import org.smirnovav.moex_lib.utils.SecurityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryUtils {
    private HistoryUtils() {
    }

    public static List<Candle> getCandles(String secId, Calendar firstDate, Calendar lastDate, int interval) {
        SecuritySpecification specification = SecurityUtils.getSecuritySpecification(secId);
        List<MoexCandle> moexCandles = getMoexCandles(specification, firstDate, lastDate, interval);
        List<Candle> candles = new ArrayList<>();
        for (MoexCandle moexCandle : moexCandles) {
            candles.add(CandleMappers.MoexCandleToCandle(moexCandle, specification.getShortName(), interval));
        }
        return candles;
    }

    public static List<Candle> getCandles(SecuritySpecification specification, Calendar firstDate, Calendar lastDate, int interval) {
        List<MoexCandle> moexCandles = getMoexCandles(specification, firstDate, lastDate, interval);
        List<Candle> candles = new ArrayList<>();
        for (MoexCandle moexCandle : moexCandles) {
            candles.add(CandleMappers.MoexCandleToCandle(moexCandle, specification.getShortName(), interval));
        }
        return candles;
    }

    public static List<MoexCandle> getMoexCandles(String secId, Calendar firstDate, Calendar lastDate, int interval) {
        if (firstDate.getTimeInMillis() > lastDate.getTimeInMillis()) {
            return null;
        }
        SecuritySpecification specification = SecurityUtils.getSecuritySpecification(secId);
        List<MoexCandle> candles = new ArrayList<>();
        Calendar firstDateTemp = (Calendar) firstDate.clone();
        Calendar lastDateTemp = (Calendar) firstDate.clone();
        lastDateTemp.add(Calendar.MINUTE, -interval);
        lastDate.add(Calendar.MINUTE, -interval);
        Duration duration = Duration.ofHours(8);
        do  {
            if (lastDate.getTimeInMillis() - firstDateTemp.getTimeInMillis() <= duration.toMillis()) {
                String strUrl = RequestBuilders.candlesJsonRequest(secId, specification.getPrimaryEngine(),
                        specification.getPrimaryMarket(), firstDateTemp, lastDate, interval);
                try {
                    URL url = new URL(strUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Type type = new TypeToken<Candles>(){}.getType();
                    Candles data = gson.fromJson(reader, type);
                    List<MoexCandle> part = CandleMappers.candlesToMoexCandles(data);
                    candles.addAll(part);
                    return candles;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                lastDateTemp.add(Calendar.HOUR, (int) duration.toHours());
                String strUrl = RequestBuilders.candlesJsonRequest(secId, specification.getPrimaryEngine(),
                        specification.getPrimaryMarket(), firstDateTemp, lastDateTemp, interval);
                try {
                    URL url = new URL(strUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Type type = new TypeToken<Candles>(){}.getType();
                    Candles data = gson.fromJson(reader, type);
                    List<MoexCandle> part = CandleMappers.candlesToMoexCandles(data);
                    candles.addAll(part);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                firstDateTemp.add(Calendar.HOUR, (int) duration.toHours());
            }
        } while (true);
    }

    public static List<MoexCandle> getMoexCandles(SecuritySpecification specification, Calendar firstDate, Calendar lastDate, int interval) {
        if (firstDate.getTimeInMillis() > lastDate.getTimeInMillis()) {
            return null;
        }
        List<MoexCandle> candles = new ArrayList<>();
        Calendar firstDateTemp = (Calendar) firstDate.clone();
        Calendar lastDateTemp = (Calendar) firstDate.clone();
        lastDateTemp.add(Calendar.MINUTE, -interval);
        lastDate.add(Calendar.MINUTE, -interval);
        Duration duration = Duration.ofHours(8);
        do  {
            if (lastDate.getTimeInMillis() - firstDateTemp.getTimeInMillis() <= duration.toMillis()) {
                String strUrl = RequestBuilders.candlesJsonRequest(specification.getSecId(), specification.getPrimaryEngine(),
                        specification.getPrimaryMarket(), firstDateTemp, lastDate, interval);
                try {
                    URL url = new URL(strUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Type type = new TypeToken<Candles>(){}.getType();
                    Candles data = gson.fromJson(reader, type);
                    List<MoexCandle> part = CandleMappers.candlesToMoexCandles(data);
                    candles.addAll(part);
                    return candles;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                lastDateTemp.add(Calendar.HOUR, (int) duration.toHours());
                String strUrl = RequestBuilders.candlesJsonRequest(specification.getSecId(), specification.getPrimaryEngine(),
                        specification.getPrimaryMarket(), firstDateTemp, lastDateTemp, interval);
                try {
                    URL url = new URL(strUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Type type = new TypeToken<Candles>(){}.getType();
                    Candles data = gson.fromJson(reader, type);
                    List<MoexCandle> part = CandleMappers.candlesToMoexCandles(data);
                    candles.addAll(part);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                firstDateTemp.add(Calendar.HOUR, (int) duration.toHours());
            }
        } while (true);
    }




    public static MoexHistory getRawHistory(String secId, Calendar firstDate, Calendar lastDate) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<MoexHistory>(){}.getType();
        String json = "";
        String forUrl = RequestBuilders.dayHistoryRequest(secId, firstDate, lastDate);
        try {
            URL url = new URL(forUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            json = reader.lines().collect(Collectors.joining());
            return gson.fromJson(json, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }









}
