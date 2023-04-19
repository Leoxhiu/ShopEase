$(document).ready(function() {

    $(document).on("scroll", onScroll);

    //smoothscroll
    $('a[href^="#"]').on('click', function(e) {
        e.preventDefault();
        $(document).off("scroll");

        $('.nav-link').each(function() {
            $(this).removeClass('active');
        })
        $(this).addClass('active');

        try{
            var target = this.hash,
                menu = target;
            $target = $(target);
            $('html, body').stop().animate({
                'scrollTop': $target.offset().top + 2
            }, 500, 'swing', function() {
                window.location.hash = target;
                $(document).on("scroll", onScroll);
            });
        } catch (e){
            $('.nav-link').each(function() {
                $(this).removeClass('active');
            })

            $(function checkPath(){
                var current = location.pathname;
                $('.nav-direct').each(function(){
                    var $this = $(this);
                    // if the current path is like this link, make it active
                    if($this.attr('href').indexOf(current) !== -1){
                        $this.addClass('active');
                    }
                })
            })
        }

    });

    $(function checkPath(){
        var current = location.pathname;
        $('.nav-direct').each(function(){
            var $this = $(this);
            // if the current path is like this link, make it active
            if($this.attr('href').indexOf(current) !== -1){
                $this.addClass('active');
            }
        })
    })
});

function onScroll(event) {
    try{
        var scrollPos = $(document).scrollTop();
        $('.nav-link').each(function() {
            var currLink = $(this);
            var refElement = $(currLink.attr("href"));
            if (refElement.position().top <= scrollPos && refElement.position().top + refElement.height() > scrollPos) {
                $('.nav-link').removeClass("active");
                currLink.addClass("active");
            } else {
                currLink.removeClass("active");
            }
        });
    } catch (e) {

    }

}