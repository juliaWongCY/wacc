#!/usr/bin/env ruby

require 'open3'

$log = "log_valid_cases.txt"

def compileCase (casePath)
    sout, serr, stat  = Open3.capture3("./compile #{casePath}")
    file = File.open($log, "a+")
    file.puts("================================================\n")
    file.puts(casePath + "\n")
    file.puts(sout)
    file.puts(serr)
    file.puts("================================================\n")
    file.puts("================================================\n")
    puts casePath + "         done\n"
    file.close unless file.nil?
 
end

File.delete($log) if File.exist?($log)
file = File.new($log, "a+")
file.close

cases = Dir.glob("./example/valid/**/*.wacc")

cases.map! {|x| compileCase(x)}
