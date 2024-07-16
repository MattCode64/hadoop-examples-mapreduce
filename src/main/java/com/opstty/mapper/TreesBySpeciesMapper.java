package com.opstty.mapper;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TreesBySpeciesMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == 0) return; // Ignorer la première ligne
        String[] fields = value.toString().split(";");
        String species = fields[3]; 
        context.write(new Text(species), new IntWritable(1));
    }
}
