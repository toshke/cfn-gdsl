cfn {

  mappings {
    add('EnvironmentType', [
            'dev' : [
                    'instanceType': 't2.small'
            ],
            'prod': [
                    'instanceType': 'm4.large'
            ]
    ])
  }

  resources {

    resource('ApplicationInstance') {
      type 'AWS::EC2::Instance'
      cfnProperties {
        InstanceType([ 'Fn::FindInMap': [ 'dev', 'instanceType' ] ])
        ImageId('ami-abcdef1199')
      }
    }

    resource('S3Bucket') {
      type 'AWS::S3::Bucket'
      cfnProperties {
        BucketName('applicationimages')
      }
    }
  }
}
