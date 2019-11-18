def plus(x, y)
    return x+y
end

def minus(x, y)
    return x-y
end

def multiply(x, y)
    return x*y
end

def divide(x, y)
    return x/y
end

while(gets.chomp()!='e')
    puts "숫자 두 개 를 입력하세요."
    x = gets.chomp.to_i
    y = gets.chomp.to_i
    puts "기호를 입력하세요."
    opt = gets.chomp

    result = case opt
        when '+' then plus x,y
        when '-' then minus x,y
        when '*' then multiply x,y
        when '/' then divide x,y
        else "잘못된 입력입니다."
    end

    puts result
end