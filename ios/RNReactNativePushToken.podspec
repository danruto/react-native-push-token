
Pod::Spec.new do |s|
  s.name         = "RNPushToken"
  s.version      = "1.0.0"
  s.summary      = "RNPushToken"
  s.description  = <<-DESC
                  RNPushToken
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "danny@pixelbru.sh" }
  s.platform     = :ios, "8.0"
  s.source       = { :git => "https://github.com/author/RNPushToken.git", :tag => "master" }
  s.source_files  = "RNPushToken/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

