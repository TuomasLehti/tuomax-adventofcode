import re
import requests
import string
import sys
from pathlib import Path

def parse_arguments():
    if len(sys.argv) != 3:
        print("Usage:")
        print("py setup.py <year> <day>")
        sys.exit()
    year = int(sys.argv[1])
    day = int(sys.argv[2])
    return year, day

def check_directories(year, day):
    p = Path(".") / "inputs" / f"year{year}" / f"day{day:02}"
    if p.exists():
        print(f"Advent of Code {year}, day {day} already set up.")
        sys.exit()

def create_directories(year, day):
    print("Creating directories")
    p_input = Path(".") / "inputs" / f"year{year}" / f"day{day:02}"
    p_input.mkdir(parents = True)
    p_code = Path(".") / "src" / "main" / "java" / "fi" / "tuomax" / "adventofcode"/ f"year{year}" / f"day{day:02}"
    p_code.mkdir(parents = True)
    p_test = Path(".") / "src" / "test" / "java" / "fi" / "tuomax" / "adventofcode"/ f"year{year}" / f"day{day:02}"
    p_test.mkdir(parents = True)

def read_session_cookie():
    p_session = Path(".") / "src" / "main" / "resources" / "setup" / "session.txt"
    file = open(p_session)
    data = file.readline()
    file.close()
    return data

def fetch_puzzle_input(year, day, login_data):
    print("Downloading input")
    # https://adventofcode.com/2016/day/22/input
    r = requests.get(f"https://adventofcode.com/{year}/day/{day}/input", cookies=login_data)
    p_input = Path(".") / "inputs" / f"year{year}" / f"day{day:02}" / f"{year}-{day:02} input.txt"
    file = open(p_input, "w")
    file.writelines(r.text)
    file.close()

def fetch_puzzle_text(year, day, login_data):
    print("Downloading text")
    r = requests.get(f"https://adventofcode.com/{year}/day/{day}", cookies=login_data)
    return r.text
    
def fetch_puzzle_name(year, day, login_data):
    lines = fetch_puzzle_text(year, day, login_data)
    puzzle_name = lines.split("---")[1].split(":")[1].strip()
    puzzle_name_pascal_cased = re.sub("\\W", "", string.capwords(puzzle_name))
    return puzzle_name, puzzle_name_pascal_cased

def create_java_class(year, day, part, puzzle_name, puzzle_name_pascal_cased):
    puzzle_data = {
        'year' : year,
        'day' : day,
        'part' : part,
        'puzzle_name' : puzzle_name,
        'puzzle_name_pascal_cased' : puzzle_name_pascal_cased
    }
    p_template = Path(".") / "src" / "main" / "resources" / "setup" / "solver_template.txt"
    file = open(p_template)
    lines = file.readlines()
    file.close()
    output = []
    for line in lines:
        output.append(line.rstrip().format(**puzzle_data))
        output.append("\n")
    p_code = Path(".") / "src" / "main" / "java" / "fi" / "tuomax" / "adventofcode"/ f"year{year}" / f"day{day:02}" / f"{puzzle_name_pascal_cased}_Part{part}.java"
    output_file = open(p_code, "w")
    output_file.writelines(output)
    output_file.close()

def create_parser_class(year, day, part, puzzle_name, puzzle_name_pascal_cased):
    puzzle_data = {
        'year' : year,
        'day' : day,
        'part' : part,
        'puzzle_name' : puzzle_name,
        'puzzle_name_pascal_cased' : puzzle_name_pascal_cased
    }
    p_template = Path(".") / "src" / "main" / "resources" / "setup" / "parser_template.txt"
    file = open(p_template)
    lines = file.readlines()
    file.close()
    output = []
    for line in lines:
        output.append(line.rstrip().format(**puzzle_data))
        output.append("\n")
    p_code = Path(".") / "src" / "main" / "java" / "fi" / "tuomax" / "adventofcode"/ f"year{year}" / f"day{day:02}" / f"{puzzle_name_pascal_cased}_Parser.java"
    output_file = open(p_code, "w")
    output_file.writelines(output)
    output_file.close()

def create_test_class(year, day, part, puzzle_name, puzzle_name_pascal_cased):
    puzzle_data = {
        'year' : year,
        'day' : day,
        'part' : part,
        'puzzle_name' : puzzle_name,
        'puzzle_name_pascal_cased' : puzzle_name_pascal_cased
    }
    p_template = Path(".") / "src" / "main" / "resources" / "setup" / "test_template.txt"
    file = open(p_template)
    lines = file.readlines()
    file.close()
    output = []
    for line in lines:
        output.append(line.rstrip().format(**puzzle_data))
        output.append("\n")
    p_code = Path(".") / "src" / "test" / "java" / "fi" / "tuomax" / "adventofcode"/ f"year{year}" / f"day{day:02}" / f"Test_{puzzle_name_pascal_cased}.java"
    output_file = open(p_code, "w")
    output_file.writelines(output)
    output_file.close()

def create_tests_json(year, day, part, puzzle_name, puzzle_name_pascal_cased):
    puzzle_data = {
        'year' : year,
        'day' : day,
        'part' : part,
        'puzzle_name' : puzzle_name,
        'puzzle_name_pascal_cased' : puzzle_name_pascal_cased
    }
    p_template = Path(".") / "src" / "main" / "resources" / "setup" / "tests_template.txt"
    file = open(p_template)
    lines = file.readlines()
    file.close()
    output = []
    for line in lines:
        output.append(line.rstrip().format(**puzzle_data))
        output.append("\n")
    p_code = Path(".") / "inputs" / f"year{year}" / f"day{day:02}" / f"{year}-{day:02} tests.json"
    output_file = open(p_code, "w")
    output_file.writelines(output)
    output_file.close()

def create_parameters_json(year, day, part, puzzle_name, puzzle_name_pascal_cased):
    puzzle_data = {
        'year' : year,
        'day' : day,
        'part' : part,
        'puzzle_name' : puzzle_name,
        'puzzle_name_pascal_cased' : puzzle_name_pascal_cased
    }
    p_template = Path(".") / "src" / "main" / "resources" / "setup" / "parameters_template.txt"
    file = open(p_template)
    lines = file.readlines()
    file.close()
    output = []
    for line in lines:
        output.append(line.rstrip().format(**puzzle_data))
        output.append("\n")
    p_code = Path(".") / "inputs" / f"year{year}" / f"day{day:02}" / f"{year}-{day:02} parameters.json"
    output_file = open(p_code, "w")
    output_file.writelines(output)
    output_file.close()

year, day = parse_arguments()
check_directories(year, day)
print(f"Setting up Advent of Code {year}, day {day}")
create_directories(year, day)
login_data = {"session" : read_session_cookie()}
puzzle_name, puzzle_name_pascal_cased = fetch_puzzle_name(year, day, login_data)
print("Creating files")
create_java_class(year, day, "1", puzzle_name, puzzle_name_pascal_cased)
create_java_class(year, day, "2", puzzle_name, puzzle_name_pascal_cased)
create_parser_class(year, day, "2", puzzle_name, puzzle_name_pascal_cased)
create_test_class(year, day, "2", puzzle_name, puzzle_name_pascal_cased)
create_tests_json(year, day, "2", puzzle_name, puzzle_name_pascal_cased)
create_parameters_json(year, day, "2", puzzle_name, puzzle_name_pascal_cased)
fetch_puzzle_input(year, day, login_data)