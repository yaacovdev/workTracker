cmake_minimum_required(VERSION 3.12)
project(UsageTracker)

set(CMAKE_CXX_STANDARD 14)

# Add your source files here
set(SOURCES
    UsageTracker.cpp
)

# Add your header files here
set(HEADERS
UsageTracker.h
)

add_executable(UsageTracker UsageTracker.cpp)